package co.com.todo1.interfaces.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import co.com.todo1.kardex.abstracts.ADto;

public class MovementDto extends ADto {
	private Integer quantity;
	private LocalDate movement;
	private SummaryDto summary;
	private ParameterDto type;
	private BigDecimal pucharseValue;
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
	public SummaryDto getSummary() {
		return summary;
	}
	public void setSummary(SummaryDto summary) {
		this.summary = summary;
	}
	public ParameterDto getType() {
		return type;
	}
	public void setType(ParameterDto type) {
		this.type = type;
	}
	public BigDecimal getPucharseValue() {
		return pucharseValue;
	}
	public void setPucharseValue(BigDecimal pucharseValue) {
		this.pucharseValue = pucharseValue;
	}
}
