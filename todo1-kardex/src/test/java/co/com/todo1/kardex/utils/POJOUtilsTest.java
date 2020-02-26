package co.com.todo1.kardex.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ParameterDto;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.kardex.pojo.SummaryResponsePOJO;

@SpringBootTest
public class POJOUtilsTest {

	
	@Test
	public void testConvertDtoToPOJOSummary() {
		SummaryDto dto = new SummaryDto();
		dto.setProduct(new ProductDto());
			
		SummaryResponsePOJO pojo = POJOUtils.convertDtoToPOJOSummary(dto);
		
		assertEquals(dto.getSaleValue(),pojo.getSaleValue());
		assertEquals(dto.getQuantity(),pojo.getQuantity());
		assertEquals(dto.getProduct().getName(),pojo.getProduct().getName());
		assertEquals(dto.getProduct().getDescription(),pojo.getProduct().getDescription());
		assertEquals(dto.getProduct().getName(),pojo.getProduct().getName());
		assertEquals(dto.getProduct().getReference(),pojo.getProduct().getReferences());
	}
	
	@Test
	public void convertDtoToRespMovement() {
		MovementDto dto = new MovementDto();
		dto.setSummary(new SummaryDto());
		dto.getSummary().setProduct(new ProductDto());
		dto.setType(new ParameterDto());
		
		MovementResponsePOJO pojo = POJOUtils.convertDtoToRespMovement(dto);
		
		assertEquals(dto.getQuantity(),pojo.getQuantity());
		assertEquals(dto.getPucharseValue(),pojo.getPucharseValue());
		//assertEquals(dto.getType(),pojo.getType());
		assertEquals(dto.getQuantity(),pojo.getQuantity());
	}

}
