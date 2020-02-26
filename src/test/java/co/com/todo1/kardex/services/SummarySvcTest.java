package co.com.todo1.kardex.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.interfaces.interfaces.ISummarySvc;
import co.com.todo1.kardex.pojo.SummaryResponsePOJO;

@SpringBootTest
public class SummarySvcTest {
	
	@Test
	public void testGet() {
		String reference = "referencia";
		SummarySvc summary = Mockito.spy(new SummarySvc());
		ISummarySvc summarySvc = Mockito.mock(ISummarySvc.class);
		SummaryDto summaryDto = new SummaryDto();

		Mockito.doReturn(summaryDto).when(summarySvc).get(Mockito.any(),Mockito.any());
		Mockito.doReturn(summarySvc).when(summary).getSvc();
		
		SummaryResponsePOJO result = summary.get(reference);
		
		assertEquals(summaryDto.getQuantity(),result.getQuantity());
		assertEquals(summaryDto.getSaleValue(),result.getSaleValue());
		assertEquals(summaryDto.getProduct().getName(),result.getProduct().getName());
		assertEquals(summaryDto.getProduct().getReference(),result.getProduct().getReferences());
		Mockito.verify(summary,Mockito.timeout(1)).getSvc();
		Mockito.verify(summarySvc,Mockito.timeout(1)).get(Mockito.any(),Mockito.any());
		
	}

}
