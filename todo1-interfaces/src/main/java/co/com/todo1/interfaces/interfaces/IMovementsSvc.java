package co.com.todo1.interfaces.interfaces;

import java.util.List;

import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ProductDto;

public interface IMovementsSvc {
		
	public MovementDto in(ProductDto product, Integer quantity,String user);
		
	public MovementDto out(ProductDto product,Integer quantity,String user);
	
	public List<MovementDto> getAllByProduct(ProductDto product,String user);
}
