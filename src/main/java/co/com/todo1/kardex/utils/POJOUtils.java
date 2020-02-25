package co.com.todo1.kardex.utils;

import co.com.todo1.interfaces.dto.ProductDto;

import java.util.Optional;

import co.com.todo1.interfaces.dto.MovementsDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.kardex.pojo.ProductRequestPOJO;
import co.com.todo1.kardex.pojo.ProductResponsePOJO;
import co.com.todo1.kardex.pojo.SummaryResponsePOJO;

public class POJOUtils {
	private POJOUtils() {}
	
	public final static ProductResponsePOJO convertDtoToRespProduct(ProductDto product) {
		ProductResponsePOJO pojo = new ProductResponsePOJO();
		pojo.setDescription(product.getDescription());
		pojo.setName(product.getName());
		pojo.setReferences(product.getReferences());
		return pojo;
	}
	
	public final static ProductResponsePOJO convertReqToRespProduct(ProductRequestPOJO product) {
		ProductResponsePOJO pojo = new ProductResponsePOJO();
		pojo.setDescription(product.getDescription());
		pojo.setName(product.getName());
		pojo.setReferences(product.getReferences());
		return pojo;
	}
	
	public final static ProductDto convertReqToDtoProduct(ProductRequestPOJO product) {
		ProductDto dto = new ProductoDto();
		dto.setDecripcion(product.getDescription());
		dto.setName(product.getName());
		dto.setReference(product.getReferences());
		return dto;
	}
	
	
	public final static MovementResponsePOJO convertDtoToRespMovement(MovementsDto dto) {
		MovementResponsePOJO pojo = new MovementResponsePOJO();
		pojo.setProductName(Optional.ofNullable(dto.getProduct()).orElse(new ProductDto()).getName());
		pojo.setMovement(dto.getMovement());
		pojo.setProductRef(dto.getProduct().getReference());
		pojo.setPucharseValue(dto.getPucharseValue());
		pojo.setQuantity(dto.getQuantity());
		pojo.setType(dto.getType());
		return pojo;
	}
	
	public final static SummaryResponsePOJO convertDtoToPOJOSummary(SummaryDto dto) {
		SummaryResponsePOJO pojo = new SummaryResponsePOJO();
		pojo.setProduct(convertDtoToPOJOProduct(dto.getProduct()));
		pojo.setPucharseValue(dto.getPucharseValue());
		pojo.setQuantity(dto.getQuantity());
		pojo.setSaleValue(dto.getSaleValue());
		return pojo;
	}
	
}
