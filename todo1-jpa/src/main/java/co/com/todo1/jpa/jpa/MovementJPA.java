package co.com.todo1.jpa.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tbl_movement")
public class MovementJPA {
	@Id
	 @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
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
	@Column(name="dmovement")
	private LocalDate movement;
	@Column(name="npucharsevalue")
	private BigDecimal pucharseValue;
	@Column(name="nsalevalue")
	private BigDecimal saleValue;
	@Column(name="nquantity")
	private Integer quantity;
	@Column(name="sinout")
	private String inOut;
	@JoinColumn(name="stype")
	@OneToOne
	private ParameterJPA type;
	@JoinColumn(name="ssummary")
	@OneToOne
	private SummaryJPA summary;
	
	public BigDecimal getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ParameterJPA getType() {
		return type;
	}
	public void setType(ParameterJPA type) {
		this.type = type;
	}
	public SummaryJPA getSummary() {
		return summary;
	}
	public void setSummary(SummaryJPA summary) {
		this.summary = summary;
	}
	public String getInOut() {
		return inOut;
	}
	public void setInOut(String inOut) {
		this.inOut = inOut;
	}
}
