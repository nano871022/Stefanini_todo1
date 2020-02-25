package co.com.todo1.interfaces.dto;

import java.math.BigDecimal;

import co.com.todo1.kardex.abstracts.ADto;

public class SummaryDto extends ADto {
	private Integer quantity;
	private BigDecimal saleValue;
	private ProductDto product;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	
	
}
