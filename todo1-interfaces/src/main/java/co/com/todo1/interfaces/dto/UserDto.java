package co.com.todo1.interfaces.dto;

import java.time.LocalDate;

import co.com.todo1.kardex.abstracts.ADto;

public class UserDto extends ADto {
	private String name;
	private String password;
	private ParameterDto state;	
	private LocalDate register;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ParameterDto getState() {
		return state;
	}
	public void setState(ParameterDto state) {
		this.state = state;
	}
	public LocalDate getRegister() {
		return register;
	}
	public void setRegister(LocalDate register) {
		this.register = register;
	}
	
	
}
