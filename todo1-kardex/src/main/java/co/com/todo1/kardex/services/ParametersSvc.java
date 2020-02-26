package co.com.todo1.kardex.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.todo1.interfaces.dto.ParameterDto;
import co.com.todo1.interfaces.interfaces.IParametersSvc;
import co.com.todo1.kardex.abstracts.ASvc;
import co.com.todo1.kardex.pojo.ParameterPOJO;
import co.com.todo1.kardex.pojo.ParameterRequestPOJO;
import co.com.todo1.kardex.pojo.ParameterResponsePOJO;
import co.com.todo1.kardex.utils.POJOUtils;
import co.com.todo1.utils.constants.StateResponse;
import co.com.todo1.utils.utils.DtoUtils;
@RestController
@RequestMapping("parameters")
public class ParametersSvc extends ASvc{
	
	@Autowired
	private IParametersSvc parameterSvc;
	
	@PostMapping("create")
	public ParameterResponsePOJO addAll(@RequestBody ParameterRequestPOJO request) {
		ParameterResponsePOJO pojo = new ParameterResponsePOJO();
		String user = "token usuario";
		for(ParameterPOJO parameter: request.getParameters()) {
			try {
			ParameterDto parameterDto = parameterSvc.add(POJOUtils.convertReqToDtoParameter(parameter), user);
			if(DtoUtils.isNotEmptyDto(parameterDto)) {
				parameter.setStatus(StateResponse.CONST_ANSWER_GOOD);
			}else {
				parameter.setStatus(StateResponse.CONST_ANSWER_BAD);
			}
			}catch(Exception e) {
				parameter.setStatus(e.getMessage());
			}
			pojo.getParameters().add(parameter);
		}
		
		return pojo;
	}
	
	@GetMapping("parameter/{group}")
	public List<ParameterPOJO> searchGroup(@PathVariable("group") String group) {
		ParameterPOJO pojo = new ParameterPOJO();
		pojo.setGroup(group);
		try {
		String user = "token usuario";
		return    parameterSvc.getByGroup(group, user).stream().map(POJOUtils::convertDtoToRespParameter).collect(Collectors.toList());
		}catch(Exception e) {
			pojo.setStatus(e.getMessage());
		}
		return null;
	}

	@GetMapping("parameter/{name}")
	public ParameterPOJO searchName(@PathVariable("name") String name) {
		ParameterPOJO pojo = new ParameterPOJO();
		pojo.setName(name);
		try {
		String user = "token usuario";
		ParameterDto dto = parameterSvc.getByName(name, user);
		return POJOUtils.convertDtoToRespParameter(dto);
		}catch(Exception e) {
			pojo.setStatus(e.getMessage());
		}
		return pojo;
	}
	
	@PostMapping("update")
	public ParameterPOJO update(@RequestBody ParameterPOJO parameter) {
		ParameterPOJO pojo = parameter;
		try {
		String user = "token usuario";
		ParameterDto dto = parameterSvc.update(POJOUtils.convertReqToDtoParameter(parameter), user);
		return POJOUtils.convertDtoToRespParameter(dto);
		}catch(Exception e) {
			pojo.setStatus(e.getMessage());
		}
		return pojo;
	}

}
