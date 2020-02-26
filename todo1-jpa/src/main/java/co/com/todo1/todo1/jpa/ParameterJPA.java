package co.com.todo1.todo1.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ParameterJPA {
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
	@Column(name="sdescriptin")
	private String description;
	@Column(name="sgroup")
	private String group;
	@Column(name="svalue")
	private String value;
}
