package co.com.todo1.utils.utils;

import org.apache.commons.lang3.StringUtils;

import co.com.todo1.kardex.abstracts.ADto;

public class DtoUtils {
	
	public static <D extends ADto>Boolean isNotEmptyDto(D dto) {
		return dto != null && StringUtils.isNotBlank(dto.getCode());
	}
}
