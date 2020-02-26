package co.com.todo1.kardex.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.interfaces.IUserSvc;
import co.com.todo1.kardex.abstracts.ASvc;
import co.com.todo1.kardex.pojo.UserRequestPOJO;
import co.com.todo1.procces.utils.InstaceSvc;

@RestController
@RequestMapping("user")
public class UserSvc extends ASvc {
	
	private IUserSvc userSvc = InstaceSvc.getInstance(IUserSvc.class);
	
	@PostMapping
	public String loggin(@RequestBody UserRequestPOJO user) {
		try {
			String password = Base64.getDecoder().decode(user.getPasswordBase64()).toString();
			return userSvc.getToken(user.getUserName(),password);
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
