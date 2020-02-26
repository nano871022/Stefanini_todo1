package co.com.todo1.todo1.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tbl_product")
public class ProductJPA {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="scode")
	private String code;
	@Column(name="suserupd")
	private String userUpdate;
	@Column(name="suserdel")
	private String userDelete;
	@Column(name="susercreate")
	private String userCreate;
	@Column(name="dupdate")
	private LocalDate update;
	@Column(name="ddelete")
	private LocalDate delete;
	@Column(name="dcreate")
	private LocalDate create;
	@Column(name="sname")
	private String name;
	@Column(name="sdescription")
	private String description;
	@Column(name="sreference")
	private String reference;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}
	public String getUserDelete() {
		return userDelete;
	}
	public void setUserDelete(String userDelete) {
		this.userDelete = userDelete;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public LocalDate getUpdate() {
		return update;
	}
	public void setUpdate(LocalDate update) {
		this.update = update;
	}
	public LocalDate getDelete() {
		return delete;
	}
	public void setDelete(LocalDate delete) {
		this.delete = delete;
	}
	public LocalDate getCreate() {
		return create;
	}
	public void setCreate(LocalDate create) {
		this.create = create;
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

}
