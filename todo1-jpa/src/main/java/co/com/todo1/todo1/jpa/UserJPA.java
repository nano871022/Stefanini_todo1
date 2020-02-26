package co.com.todo1.todo1.jpa;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tbl_user")
public class UserJPA {
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
	@Column(name="spassword")
	private String password;
	@Column(name="sstate")
	private ParameterJPA state;
	@Column(name="dregister")
	private LocalDate register;
}
