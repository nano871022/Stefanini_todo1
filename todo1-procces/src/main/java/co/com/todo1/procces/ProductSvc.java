package co.com.todo1.procces;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IProductSvc;
import co.com.todo1.procces.utils.JPAUtils;
import co.com.todo1.todo1.jpa.ProductJPA;
import co.com.todo1.todo1.repository.ProductRepository;

@Service
public class ProductSvc implements IProductSvc{
	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;
	
	public Boolean add(ProductDto product, String user) {
		logger.info("agregando registro");
		ProductJPA jpa = productRepository.save(JPAUtils.convertDtoToJPA(product));
		logger.info("Registro agregado");
		return JPAUtils.isNotBlank(jpa);
	}

	public ProductDto get(ProductDto product, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductDto> getAll(String user) {
		return productRepository.findAll().stream().map(JPAUtils::convertJPAToDto).collect(Collectors.toList());
	}

}
