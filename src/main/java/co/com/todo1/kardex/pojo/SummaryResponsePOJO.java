package co.com.todo1.kardex.pojo;

import java.math.BigDecimal;

public class SummaryResponsePOJO extends APOJO {
	
	private ProductResponsePOJO product;
	private Integer quantity;
	private BigDecimal pucharseValue;
	private BigDecimal saleValue;
	
	public SummaryResponsePOJO() {}
	public SummaryResponsePOJO(String reference) {
		product = new ProductResponsePOJO();
		product.setReferences(reference);
	}
	
	public ProductResponsePOJO getProduct() {
		return product;
	}
	public void setProduct(ProductResponsePOJO product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPucharseValue() {
		return pucharseValue;
	}
	public void setPucharseValue(BigDecimal pucharseValue) {
		this.pucharseValue = pucharseValue;
	}
	public BigDecimal getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}
	
	
}
