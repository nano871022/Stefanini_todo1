package co.com.todo1.kardex.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovementsPOJO {
	
	private String refProduct;
	private Integer quantity;
	private BigDecimal pucharseValue;
	private LocalDate movement;
	
	
	public LocalDate getMovement() {
		return movement;
	}
	public void setMovement(LocalDate movement) {
		this.movement = movement;
	}
	public String getRefProduct() {
		return refProduct;
	}
	public void setRefProduct(String refProduct) {
		this.refProduct = refProduct;
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
	
	
}
