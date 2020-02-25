package co.com.todo1.kardex.services;

import java.util.IntSummaryStatistics;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.todo1.kardex.pojo.SummaryResponsePOJO;

@SpringBootTest
public class SummarySvcTest {
	
	@Test
	public void testGet() {
		String reference = "referencia";
		SummarySvc summary = Mockito.spy(new SummarySvc());
		ISumarySvc summarySvc = Mockito.mock(ISummarySvc.class);
		SummaryDto summaryDto = new SummaryDto();

		Mockito.doReturn(summaryDto).when(summarySvc).get(Mockito.any(),Mockito.any());
		Mockito.doReturn(summarySvc).when(summary).getSvc();
		
		SummaryResponsePOJO result = summary.get(reference);
		
		asserEquals(summaryDto.getQuantity(),result.getQuantity());
		asserEquals(summaryDto.getSaleValue(),result.getSaleValue());
		asserEquals(summaryDto.getStatus(),result.getStatus());
		asserEquals(summaryDto.getProduct().getName(),result.getProduct().getName());
		asserEquals(summaryDto.getProduct().getReferences(),result.getProduct().getReferences());
		Mockito.verify(summary,Mockito.timeout(1)).getSvc();
		Mockito.verify(summarySvc,Mockito.timeout(1)).get(Mockito.any(),Mockito.any());
		
	}

}
