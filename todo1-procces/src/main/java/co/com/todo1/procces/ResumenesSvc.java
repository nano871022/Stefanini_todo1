package co.com.todo1.procces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.abstracs.ASvc;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.interfaces.interfaces.ISummarySvc;
import co.com.todo1.jpa.jpa.ProductJPA;
import co.com.todo1.jpa.jpa.SummaryJPA;
import co.com.todo1.jpa.repository.SummaryRepository;
import co.com.todo1.procces.utils.JPAUtils;

@Service
public class ResumenesSvc extends ASvc implements ISummarySvc {
	
	@Autowired
	private SummaryRepository summarySvc;
	
	public SummaryDto get(ProductDto producto, String user) {
		ProductJPA prod = JPAUtils.convertDtoToJPA(producto);
		SummaryJPA jpa = summarySvc.findByProduct(prod);
		return JPAUtils.convertJPAToDto(jpa);
	}

}
