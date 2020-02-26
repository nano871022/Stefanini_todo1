package co.com.todo1.kardex.abstracts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.kardex.pojo.ProductResponsePOJO;
import co.com.todo1.utils.utils.I18n;

@SpringBootTest
public class ASvcTest {
	
	@Test
	public void testErrorReturnByException() {
		ASvc svc = Mockito.mock(ASvc.class);
		String errMessage = "Err call method";
		Exception ex = new Exception(errMessage);
		
		Mockito.doCallRealMethod().when(svc).errorReturn(ex, ProductResponsePOJO.class);
		
		ProductResponsePOJO result = svc.errorReturn(ex, ProductResponsePOJO.class);
		
		assertEquals(errMessage,result.getStatus());
	}
	
	@Test
	public void testErrorReturnByMessageString() {
		ASvc svc = Mockito.mock(ASvc.class);
		String errMessage = "Err call method";
		
		Mockito.doCallRealMethod().when(svc).errorReturn(errMessage, MovementResponsePOJO.class);
		
		MovementResponsePOJO result = svc.errorReturn(errMessage, MovementResponsePOJO.class);
		
		assertEquals(errMessage,result.getStatus());
	}
	
	@Test
	public void testI18n() {
		ASvc svc = Mockito.mock(ASvc.class);
		String messageOut = "mensaje test";
		I18n i18n = Mockito.mock(I18n.class);
		
		Mockito.doReturn(i18n).when(svc).i18n();
		Mockito.doReturn(messageOut).when(i18n).get(Mockito.any());
		Mockito.doCallRealMethod().when(svc).i18n(Mockito.any());
		
		String result = svc.i18n("err.message.test");
		
		assertEquals(messageOut,result);
		Mockito.verify(i18n,Mockito.times(1)).get(Mockito.any());
		Mockito.verify(svc,Mockito.times(1)).i18n();
	}

}
