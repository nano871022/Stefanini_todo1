package co.com.todo1.interfaces.interfaces;

import java.util.List;

import co.com.todo1.interfaces.dto.ProductDto;

public interface IProductSvc {
	
	public Boolean add(ProductDto product,String user);
	
	public ProductDto get(ProductDto product,String user);
	
	public List<ProductDto> getAll(String user);

}
