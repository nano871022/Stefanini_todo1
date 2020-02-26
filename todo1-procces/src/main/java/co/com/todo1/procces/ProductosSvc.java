package co.com.todo1.procces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.abstracs.ASvc;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IProductSvc;
import co.com.todo1.jpa.jpa.ProductJPA;
import co.com.todo1.jpa.repository.ProductRepository;
import co.com.todo1.procces.utils.JPAUtils;

@Service
public class ProductosSvc extends ASvc implements IProductSvc{

	@Autowired
	private ProductRepository productRepository;
	
	public Boolean add(ProductDto product, String user) {
		logger.info("agregando registro");
		ProductJPA jpa = productRepository.save(JPAUtils.convertDtoToJPA(product));
		logger.info("Registro agregado");
		return JPAUtils.isNotBlank(jpa);
	}

	public ProductDto get(ProductDto product, String user) {
		ProductJPA result = productRepository.findByReference(product.getReference());
		return JPAUtils.convertJPAToDto(result);
	}

	public List<ProductDto> getAll(String user) {
		return productRepository.findAll().stream()
				.filter(JPAUtils::isNotBlank)
				.map(JPAUtils::convertJPAToDto)
				.filter(JPAUtils::isNotNull)
				.peek(map->logger.info(map.getClass().getSimpleName()+" :: "+map.getCode()))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
