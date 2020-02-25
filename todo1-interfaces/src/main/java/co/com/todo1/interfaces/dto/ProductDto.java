package co.com.todo1.interfaces.dto;

import co.com.todo1.kardex.abstracts.ADto;

public class ProductDto extends ADto {
	private String name;
	private String description;
	private String reference;
	private ParameterDto state;
	public ProductDto() {}
	public ProductDto(String reference) {
		this.reference = reference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public ParameterDto getState() {
		return state;
	}
	public void setState(ParameterDto state) {
		this.state = state;
	}
	
	
}
