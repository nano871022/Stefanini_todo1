package co.com.todo1.kardex.abstracts;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public abstract class ADto {
	private String code;
	private String userUpdate;
	private String userDelete;
	private String userCreate;
	private LocalDate update;
	private LocalDate delete;
	private LocalDate create;
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
	Predicate<Method> validMethod = val->val.getName().contains("get") && val.getParameterCount() == 0;
	Function<Method,String> toString = val-> {
		try {
		return val.getName().replace("get", "")+":"+val.invoke(this);
		}catch(Exception e) {
			return null;
		}
	};
	
	public String toString() {
		return search(this.getClass()).stream().reduce("",(val1,val2)->val1 += (val1.length()!=0?",":"")+val2);
	}
	
	private List<String> search(Class clazz) {
		if(clazz != Object.class) {
			List<String> list = Arrays.asList(clazz.getDeclaredMethods())
			.stream().filter(validMethod)
			.map(toString).collect(Collectors.toList());
			 list.addAll(search(clazz.getSuperclass()));
			 return list;
		}
		return null;
	}
}
