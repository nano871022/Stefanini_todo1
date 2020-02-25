package co.com.todo1.interfaces.dto;

import co.com.todo1.kardex.abstracts.ADto;

public class ProductUserDto extends ADto {
	private ProductDto product;
	private UserDto user;
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
}
