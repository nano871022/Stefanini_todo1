package co.com.todo1.jpa.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_producuser")
public class ProductUserJPA {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="scode")
	private String code;
	@JoinColumn(name="sproduct")
	@OneToOne
	private ProductJPA product;
	@JoinColumn(name="suser")
	@OneToOne
	private UserJPA user;
	
	public ProductJPA getProduct() {
		return product;
	}
	public void setProduct(ProductJPA product) {
		this.product = product;
	}
	public UserJPA getUser() {
		return user;
	}
	public void setUser(UserJPA user) {
		this.user = user;
	}
	
}
