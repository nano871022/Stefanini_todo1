package co.com.todo1.interfaces.interfaces;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;

public interface ISummarySvc {

	public SummaryDto get(ProductDto producto,String user);
}
