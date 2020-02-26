package co.com.todo1.kardex.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MovementResponsePOJO extends APOJO{
	private String productRef;
	private String productName;
	private Integer quantity;
	private LocalDate movement;
	private BigDecimal pucharseValue;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MovementResponsePOJO() {}
	
	public MovementResponsePOJO(MovementResponsePOJO movement) {
		this.productRef = movement.getProductRef();
		this.quantity = movement.getQuantity();
		this.movement = movement.getMovement();
	}
	
	public MovementResponsePOJO(MovementsRequestPOJO movement) {
		this.productRef = movement.getRefProduct();
		this.quantity = movement.getQuantity();
		this.movement = movement.getMovement();
	}
	
	public String getProductRef() {
		return productRef;
	}

	public void setProductRef(String productRef) {
		this.productRef = productRef;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getMovement() {
		return movement;
	}

	public void setMovement(LocalDate movement) {
		this.movement = movement;
	}

	public BigDecimal getPucharseValue() {
		return pucharseValue;
	}

	public void setPucharseValue(BigDecimal pucharseValue) {
		this.pucharseValue = pucharseValue;
	}

}
