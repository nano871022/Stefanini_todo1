package co.com.todo1.procces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.todo1.interfaces.dto.ParameterDto;
import co.com.todo1.interfaces.interfaces.IParametersSvc;
import co.com.todo1.jpa.repository.ParameterRepository;
import co.com.todo1.procces.utils.JPAUtils;

@Service
public class ParametrosSvc implements IParametersSvc {

	@Autowired
	private ParameterRepository parameterRepository;
	
	@Override
	public ParameterDto add(ParameterDto dto, String user) {
		return JPAUtils.convertJPAToDto(parameterRepository.save(JPAUtils.convertDtoToJPA(dto)));
	}

	@Override
	public ParameterDto getByName(String name, String user) {
		return JPAUtils.convertJPAToDto(parameterRepository.findByName(name));
	}

	@Override
	public List<ParameterDto> getByGroup(String group, String user) {
		return parameterRepository.findByGroup(group).stream().map(JPAUtils::convertJPAToDto).collect(Collectors.toList());
	}

	@Override
	public ParameterDto update(ParameterDto dto, String user) {
		return JPAUtils.convertJPAToDto(parameterRepository.save(JPAUtils.convertDtoToJPA(dto)));
	}

}
