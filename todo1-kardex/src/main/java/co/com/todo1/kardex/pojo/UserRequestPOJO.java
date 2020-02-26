package co.com.todo1.kardex.pojo;

public class UserRequestPOJO extends APOJO {
	private String userName;
	private String passwordBase64;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordBase64() {
		return passwordBase64;
	}
	public void setPasswordBase64(String passwordBase64) {
		this.passwordBase64 = passwordBase64;
	}
}
