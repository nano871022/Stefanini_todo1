package co.com.todo1.procces;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.abstracs.ASvc;
import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IMovementsSvc;
import co.com.todo1.jpa.jpa.MovementJPA;
import co.com.todo1.jpa.jpa.ParameterJPA;
import co.com.todo1.jpa.jpa.ProductJPA;
import co.com.todo1.jpa.jpa.SummaryJPA;
import co.com.todo1.jpa.repository.MovementRepository;
import co.com.todo1.jpa.repository.ParameterRepository;
import co.com.todo1.jpa.repository.ProductRepository;
import co.com.todo1.jpa.repository.SummaryRepository;
import co.com.todo1.procces.utils.JPAUtils;
import co.com.todo1.utils.constants.MovementConstants;
import co.com.todo1.utils.utils.I18n;

@Service
public class MovimientosSvc extends ASvc implements IMovementsSvc{
	
	@Autowired
	private ParameterRepository parameterRepository;
	@Autowired
	private MovementRepository movementSvc;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SummaryRepository summaryRepository;
	
	public MovementDto in(ProductDto product, Integer quantity,BigDecimal pucharseValue, String user) {
		
		ProductJPA productJPA = productRepository.findByReference(product.getReference());
		if(!JPAUtils.isNotBlank(productJPA)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementssvc.in.product.notfound"));
		}
		SummaryJPA summaryJPA = summaryRepository.findByProduct(productJPA);
		if(!JPAUtils.isNotBlank(summaryJPA)) {
			SummaryJPA summaryJPAC = new SummaryJPA();
			summaryJPAC.setProduct(productJPA);
			summaryJPAC.setCreate(LocalDate.now());
			summaryJPAC.setUserCreate(user);
			summaryJPAC.setQuantity(0);
			summaryJPAC.setSaleValue(new BigDecimal(0));
			summaryJPA = summaryRepository.save(summaryJPAC);
		}
		
		ParameterJPA type = parameterRepository.findTypeMovementActive();
		if(!JPAUtils.isNotBlank(type)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.in.typemovement.notfound"));
		}
		
		MovementJPA jpa = new MovementJPA();
		jpa.setType(type);
		jpa.setSummary(summaryJPA);
		jpa.setQuantity(quantity);
		jpa.setPucharseValue(pucharseValue);
		jpa.setInOut(MovementConstants.CONST_MOVEMENT_IN);
		
		if(type.getValue() == "LIFO") {
			calculateByMovementAndUpdateLIFO(summaryJPA,jpa,user);
		}else if(type.getValue() == "FIFO") {
			calculateByMovementAndUpdateFIFO(summaryJPA,jpa,user);
		}else {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.in.typemovement.invalid"));
		}
		
		jpa = movementSvc.save(jpa);
		return JPAUtils.convertJPAToDto(jpa);
	}
	
	private void calculateByMovementAndUpdateLIFO(SummaryJPA summary,MovementJPA movement,String user) {
		Integer quantity = movement.getQuantity();
		BigDecimal saleValue = movement.getPucharseValue();
		
		List<MovementDto> list = getAllByProduct(JPAUtils.convertJPAToDto(summary.getProduct()), user);
		BigDecimal sum = list.stream().filter(val->MovementConstants.CONST_MOVEMENT_IN.contains(val.getType().getValue()))
		.map(val->val.getPucharseValue()).reduce(new BigDecimal(0),(val1,val2)->val1.add(val2));
		Long count = list.stream().filter(val->MovementConstants.CONST_MOVEMENT_IN.contains(val.getType().getValue())).count();
		BigDecimal pucharseValue = sum.divide(new BigDecimal(count));
		quantity = Integer.sum(quantity, summary.getQuantity());
		
		ParameterJPA percentage = parameterRepository.findPorcVentaProductActive(summary.getProduct().getReference());
		if(!JPAUtils.isNotBlank(percentage)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.lifo.percentsale.notfound")); 
		}
		saleValue = pucharseValue.multiply(new BigDecimal(percentage.getValue()));
				
		summary.setQuantity(quantity);
		summary.setSaleValue(saleValue);
		summary.setPucharseValue(pucharseValue );
		summary = summaryRepository.save(summary);
	}
	
	private void calculateByMovementAndUpdateFIFO(SummaryJPA summary,MovementJPA movement,String user) {
		Integer quantity = movement.getQuantity();
		BigDecimal saleValue = movement.getPucharseValue();
		
		List<MovementDto> list = getAllByProduct(JPAUtils.convertJPAToDto(summary.getProduct()), user);
		BigDecimal sum = list.stream().filter(val->MovementConstants.CONST_MOVEMENT_IN.contains(val.getType().getValue()))
		.map(val->val.getPucharseValue()).reduce(new BigDecimal(0),(val1,val2)->val1.add(val2));
		Long count = list.stream().filter(val->MovementConstants.CONST_MOVEMENT_IN.contains(val.getType().getValue())).count();
		BigDecimal pucharseValue = sum.divide(new BigDecimal(count));
		quantity = Integer.sum(quantity, summary.getQuantity());
		
		ParameterJPA percentage = parameterRepository.findPorcVentaProductActive(summary.getProduct().getReference());
		if(!JPAUtils.isNotBlank(percentage)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.fifo.percentsale.notfound")); 
		}
		saleValue = movement.getPucharseValue().multiply(new BigDecimal(percentage.getValue()));
		
		summary.setQuantity(quantity);
		summary.setSaleValue(saleValue);
		summary.setPucharseValue(pucharseValue);
		summary = summaryRepository.save(summary);
	}

	public MovementDto out(ProductDto product, Integer quantity, String user) {

		ProductJPA productJPA = productRepository.findByReference(product.getReference());
		if(!JPAUtils.isNotBlank(productJPA)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementssvc.out.product.notfound"));
		}
		SummaryJPA summaryJPA = summaryRepository.findByProduct(productJPA);
		if(!JPAUtils.isNotBlank(summaryJPA)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.out.summary.notfound"));
		}
		if(summaryJPA.getQuantity() == 0) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.out.summary.quantity.zero"));
		}
		if(summaryJPA.getQuantity() < quantity) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.out.summary.quantity.unenough"));
		}
		
		ParameterJPA type = parameterRepository.findTypeMovementActive();
		if(!JPAUtils.isNotBlank(type)) {
			throw new RuntimeException(I18n.INSTANCE().get("err.movementsvc.in.typemovement.notfound"));
		}
		
		MovementJPA jpa = new MovementJPA();
		jpa.setType(type);
		jpa.setSummary(summaryJPA);
		jpa.setQuantity(quantity);
		jpa.setInOut(MovementConstants.CONST_MOVEMENT_OUT);
		jpa.setSaleValue(summaryJPA.getSaleValue());
		
		summaryJPA.setQuantity(Integer.sum(summaryJPA.getQuantity(), quantity*-1));
		summaryJPA = summaryRepository.save(summaryJPA);
		
		jpa = movementSvc.save(jpa);
		
		return null;
	}

	public List<MovementDto> getAllByProduct(ProductDto product, String user) {
		return movementSvc.findAllByProduct(JPAUtils.convertDtoToJPA(product))
				.stream().map(JPAUtils::convertJPAToDto).collect(Collectors.toList());
	}
   
}
