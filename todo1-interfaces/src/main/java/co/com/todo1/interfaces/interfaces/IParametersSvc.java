package co.com.todo1.interfaces.interfaces;

import java.util.List;

import co.com.todo1.interfaces.dto.ParameterDto;

public interface IParametersSvc {

	public ParameterDto add(ParameterDto dto,String user);
	
	public ParameterDto getByName(String name,String user);
	
	public List<ParameterDto> getByGroup(String group,String user);
	
	public ParameterDto update(ParameterDto dto,String user);
}
