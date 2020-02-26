package co.com.todo1.procces;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import co.com.todo1.interfaces.dto.UserDto;
import co.com.todo1.interfaces.interfaces.IUserSvc;

@Service
public class UserSvc implements IUserSvc {

	public String getToken(String userName, String password)  {
		try {
			UserDto dto = new UserDto();
			dto.setName(userName);
			dto.setPassword(password);
		//	TODO verificar que sea el  usuario sea correcto
			return generateToken(dto);
		}catch(NoSuchAlgorithmException e) {
			
		}
		return null;
	}
	
	protected String generateToken(UserDto dto) throws NoSuchAlgorithmException {
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
