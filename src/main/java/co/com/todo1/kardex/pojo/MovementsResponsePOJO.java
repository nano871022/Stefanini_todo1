package co.com.todo1.kardex.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.com.todo1.interfaces.dto.MovementDto;

public class MovementsResponsePOJO {
	
	private String refProduct;
	private Integer quantity;
	private BigDecimal pucharseValue;
	private LocalDate movement;
	private String state;
	
	public MovementsResponsePOJO() {}
	
	public MovementsResponsePOJO(MovementsPOJO movementInput) {
		refProduct = movementInput.getRefProduct();
		quantity = movementInput.getQuantity();
		pucharseValue = movementInput.getPucharseValue();
		movement = movementInput.getMovement();
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
