package co.com.todo1.kardex.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.kardex.pojo.SummaryResponsePOJO;

@SpringBootTest
public class POJOUtilsTest {

	
	@Test
	public void testConvertDtoToPOJOSummary() {
		POJOUtils util = Mockito.mock(POJOUtils.class);
		SummaryDto dto = new SummaryDto();
		
		SummaryResponsePOJO pojo = util.convertDtoToPOJOSummary(dto);
		
		assertEquals(dto.getStatus(),pojo.getStatus());
		assertEquals(dto.getSsaleValue(),pojo.getSaleValue());
		assertEquals(dto.getQuantity(),pojo.getQuantity());
		assertEquals(dto.getPucharseValue(),pojo.getPucharseValue());
		assertEquals(dto.getProduct().getName(),pojo.getProduct().getName());
		assertEquals(dto.getProduct().getDescription(),pojo.getProduct().getDescription());
		assertEquals(dto.getProduct().getName(),pojo.getProduct().getName());
		assertEquals(dto.getProduct().getReferences(),pojo.getProduct().getReferences());
		assertEquals(dto.getProduct().getStatus(),pojo.getProduct().getStatus());
	}
	
	@Test
	public void convertDtoToRespMovement() {
		POJOUtils util = Mockito.mock(POJOUtils.class);
		MovementsDto dto = new MovementsDto();
		
		MovementResponsePOJO pojo = util.convertDtoToRespMovement(dto);
		
		assertEquals(dto.getStatus(),pojo.getStatus());
		assertEquals(dto.getQuantity(),pojo.getQuantity());
		assertEquals(dto.getPucharseValue(),pojo.getPucharseValue());
		assertEquals(dto.getProduct().getName(),pojo.getProductName());
		assertEquals(dto.getType(),pojo.getType());
		assertEquals(dto.getQuantity(),pojo.getQuantity());
	}

}
