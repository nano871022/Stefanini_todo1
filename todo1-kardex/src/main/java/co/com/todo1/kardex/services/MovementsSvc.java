package co.com.todo1.kardex.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.interfaces.IMovementsSvc;
import co.com.todo1.kardex.abstracts.ASvc;
import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.kardex.pojo.MovementsRequestPOJO;
import co.com.todo1.kardex.utils.POJOUtils;
import co.com.todo1.utils.constants.StateResponse;
import co.com.todo1.utils.utils.ListUtils;
import co.com.todo1.procces.utils.InstaceSvc;
@RestController
@RequestMapping("movements")
public class MovementsSvc extends ASvc{
	@Autowired
	private IMovementsSvc movements = InstaceSvc.getInstance(IMovementsSvc.class);
	
	@PostMapping("/input/")
	public MovementResponsePOJO in(@RequestBody MovementsRequestPOJO movement) {
		String user = "token-spring-boot";
		MovementResponsePOJO movementOut = new MovementResponsePOJO(movement);
		try {
			MovementDto result = movements.in(new ProductDto(movement.getRefProduct()), movement.getQuantity(),movement.getPucharseValue(), user);
			movementOut = POJOUtils.convertDtoToRespMovement(result);
			movementOut.setStatus(StateResponse.CONST_ANSWER_GOOD);
		}catch(RuntimeException e) {
			movementOut.setStatus(e.getMessage());
		}catch(Exception e) {
			movementOut.setStatus(e.getMessage());
		}
		return movementOut;
	}
	
	@PostMapping("/output")
	public MovementResponsePOJO out(@RequestBody MovementsRequestPOJO movement) {
		String user = "token-spring-boot";
		MovementResponsePOJO movementOut = new MovementResponsePOJO(movement);
		try {
			MovementDto result= movements.out(new ProductDto(movement.getRefProduct()), movement.getQuantity(), user);
			movementOut = POJOUtils.convertDtoToRespMovement(result);
			movementOut.setStatus(StateResponse.CONST_ANSWER_GOOD);
		}catch(RuntimeException e) {
			movementOut.setStatus(e.getMessage());
		}catch(Exception e) {
			movementOut.setStatus(e.getMessage());
		}
		return movementOut;
	}
	
	@GetMapping("/movements/{ReferenceProduct}")
	public List<MovementResponsePOJO> getAllByProduct(@PathVariable("ReferenceProduct") String refProduct){
		String user = "token-spring-boot";
		List<MovementResponsePOJO> returnError = new ArrayList<>();
		try {
			ProductDto product = new ProductDto(refProduct);
			List<MovementDto> list = movements.getAllByProduct(product,user);
			if(ListUtils.isNotEmpty(list)) {
				return list.stream().map(POJOUtils::convertDtoToRespMovement).collect(Collectors.toList());
			}
		}catch(RuntimeException e) {
			returnError.add(errorReturn(e,MovementResponsePOJO.class));
		}catch(Exception e) {
			returnError.add(errorReturn(e,MovementResponsePOJO.class));
		}
		if(returnError.size() == 0) {
			returnError.add(errorReturn(i18n("warn.movements.getallbyproduct.not.found"),MovementResponsePOJO.class));
		}
		return returnError;
	}
	
	@GetMapping("/test")
	public String test() {
		return i18n("warn.movements.test.testing.method");
	}
	
	
	
}
