package co.com.todo1.todo1.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tbl_movement")
public class MovementJPA {
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
	@Column(name="dmovement")
	private LocalDate movement;
	@Column(name="npucharsevalue")
	private BigDecimal pucharseValue;
	@Column(name="nquantity")
	private Integer quantity;
	@Column(name="stype")
	private ParameterJPA type;
	@Column(name="ssummary")
	private SummaryJPA summary;
}
