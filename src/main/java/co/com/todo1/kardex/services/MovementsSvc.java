package co.com.todo1.kardex.services;

import org.h2.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IMovementsSvc;
import co.com.todo1.kardex.pojo.MovementsPOJO;
import co.com.todo1.kardex.pojo.MovementsResponsePOJO;
import co.com.todo1.utils.constants.StateResponse;
import co.com.todo1.utils.utils.DtoUtils;
import co.com.todo1.utils.utils.I18n;

@RestController
@RequestMapping("Movements")
public class MovementsSvc {
	
	private IMovementsSvc movements;
	
	@PostMapping("/input/")
	public MovementsResponsePOJO in(@RequestBody MovementsPOJO movement) {
		String user = "token-spring-boot";
		MovementsResponsePOJO movementOut = new MovementsResponsePOJO(movement);
		MovementDto result = null;
		try {
			result = movements.in(new ProductDto(movement.getRefProduct()), movement.getQuantity(), user);
		}catch(RuntimeException e) {
			movementOut.setState(e.getMessage());
		}catch(Exception e) {
			movementOut.setState(e.getMessage());
		}
		if(DtoUtils.isNotEmptyDto(result)) {
			movementOut.setState(StateResponse.CONST_ANSWER_GOOD);
		}else if(StringUtils.isNullOrEmpty(movementOut.getState())){
			movementOut.setState(StateResponse.CONST_ANSWER_BAD);
		}
		return movementOut;
	}
	
	@GetMapping("/test")
	public String test() {
		return I18n.INSTANCE().get("warn.movements.test.testing.method");
	}
	
	
	
}
