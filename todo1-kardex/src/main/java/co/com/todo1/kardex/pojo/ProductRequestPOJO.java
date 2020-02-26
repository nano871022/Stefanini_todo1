package co.com.todo1.kardex.pojo;

public class ProductRequestPOJO extends APOJO {
	 private String name;
	 private String description;
	 private String references;
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
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		this.references = references;
	}
	 
}
