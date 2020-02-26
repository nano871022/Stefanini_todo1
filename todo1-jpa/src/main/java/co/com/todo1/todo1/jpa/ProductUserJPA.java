package co.com.todo1.todo1.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tbl_producuser")
public class ProductUserJPA {

	@Id
	@Column(name="sproduct")
	private ProductJPA product;
	@Id
	@Column(name="suser")
	private UserJPA user;
}
