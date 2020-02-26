package co.com.todo1.procces;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.abstracs.ASvc;
import co.com.todo1.interfaces.dto.UserDto;
import co.com.todo1.interfaces.interfaces.IUserSvc;
import co.com.todo1.jpa.jpa.UserJPA;
import co.com.todo1.jpa.repository.UserRepository;
import co.com.todo1.procces.utils.JPAUtils;
import co.com.todo1.utils.utils.I18n;

@Service
public class UsuariosSvc extends ASvc implements IUserSvc {
	
	@Autowired
	private UserRepository userSvc;
	
	public String getToken(String userName, String password)  {
		try {
			UserJPA jpa = userSvc.finLoggin(userName,password);
			if(JPAUtils.isNotBlank(jpa)) {
				return generateToken(jpa);
			}else {
				throw new RuntimeException(I18n.INSTANCE().get("err.usuariossvc.find.user.notfound"));
			}
		}catch(NoSuchAlgorithmException e) {
			
		}
		return null;
	}
	
	protected String generateToken(UserJPA dto) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(new StringBuilder().append(dto.getName()).append(dto.getPassword()).append(dto.getCreate()).toString().getBytes());
		return Base64.getEncoder().encode(md.digest()).toString();
	}
	
	protected UserDto searchToken(String token) {
		UserDto user = new UserDto();
		//TODO se realiza busqueda del token para obtener el usuario
		return user;
	}

}
