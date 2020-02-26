package co.com.todo1.procces;

import org.springframework.stereotype.Service;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.interfaces.interfaces.ISummarySvc;

@Service
public class SummarySvc implements ISummarySvc {

	public SummaryDto get(ProductDto producto, String user) {
		
		return null;
	}

}
