package co.com.todo1.kardex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.interfaces.interfaces.ISummarySvc;
import co.com.todo1.kardex.abstracts.ASvc;
import co.com.todo1.kardex.pojo.SummaryResponsePOJO;
import co.com.todo1.kardex.utils.POJOUtils;
import co.com.todo1.procces.utils.InstaceSvc;

@RequestMapping("summary")
@RestController
public class SummarySvc extends ASvc {
	@Autowired
	private ISummarySvc summarySvc = InstaceSvc.getInstance(ISummarySvc.class);
	
	@GetMapping("product/{reference}")
	public SummaryResponsePOJO get(@PathVariable("reference") String reference) {
		String user = "user get api-key";
		SummaryResponsePOJO pojo = new SummaryResponsePOJO(reference);
		ProductDto product = new ProductDto(reference);
		try {
			SummaryDto summary = getSvc().get(product,user);
			return POJOUtils.convertDtoToPOJOSummary(summary);
		}catch(RuntimeException e) {
			pojo.setStatus(e.getMessage());
		}catch(Exception e) {
			pojo.setStatus(e.getMessage());
		}
		return pojo;
	}
	
	protected ISummarySvc getSvc() {
		return summarySvc;
	}
}
