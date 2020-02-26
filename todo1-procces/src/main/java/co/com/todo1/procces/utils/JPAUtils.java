package co.com.todo1.procces.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.todo1.interfaces.dto.MovementDto;
import co.com.todo1.interfaces.dto.ParameterDto;
import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.interfaces.dto.SummaryDto;
import co.com.todo1.interfaces.dto.UserDto;
import co.com.todo1.jpa.jpa.MovementJPA;
import co.com.todo1.jpa.jpa.ParameterJPA;
import co.com.todo1.jpa.jpa.ProductJPA;
import co.com.todo1.jpa.jpa.SummaryJPA;
import co.com.todo1.jpa.jpa.UserJPA;
import co.com.todo1.kardex.abstracts.ADto;

public class JPAUtils {
	static Logger logger = LogManager.getLogger(JPAUtils.class);
	
	public static <A extends ADto>Boolean isNotNull(A dto) {
		return (dto != null && StringUtils.isNoneBlank(dto.getCode()));
	}
	
	public static <D>Boolean isNotBlank(D jpa) {
		logger.info("Verificado si jpa no esta vacio"+jpa);
		try {
			if(jpa != null) {
				Method code = jpa.getClass().getDeclaredMethod("getCode");
				String value = (String)code.invoke(jpa);
				if(StringUtils.isNoneBlank(value)) {
					return true;
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			logger.error(e);
		}
		return false;
	}
	
	public static SummaryDto convertJPAToDto(SummaryJPA jpa) {
		SummaryDto dto = new SummaryDto();
		dto.setCode(jpa.getCode());
		dto.setCreate(jpa.getCreate());
		dto.setDelete(jpa.getDelete());
		dto.setUpdate(jpa.getUpdate());
		dto.setUserCreate(jpa.getUserCreate());
		dto.setUserDelete(jpa.getUserDelete());
		dto.setUserUpdate(jpa.getUserUpdate());
		dto.setQuantity(jpa.getQuantity());
		dto.setSaleValue(jpa.getSaleValue());
		dto.setProduct(convertJPAToDto(jpa.getProduct()));
		dto.setQuantity(jpa.getQuantity());
		return dto;
	}
	
	public static ProductDto convertJPAToDto(ProductJPA product) {
		logger.info("Iniciando proceso de copia para ProductJPA a ProductDto "+isNotBlank(product));
		ProductDto dto = new ProductDto();
		dto.setCode(product.getCode());
		dto.setCreate(product.getCreate());
		dto.setDelete(product.getDelete());
		dto.setUpdate(product.getUpdate());
		dto.setUserCreate(product.getUserCreate());
		dto.setUserDelete(product.getUserDelete());
		dto.setUserUpdate(product.getUserUpdate());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setReference(product.getReference());
		logger.info("Fin de proceso de copia.");
		return dto;
	}
	
	public static ProductJPA convertDtoToJPA(ProductDto product) {
		ProductJPA dto = new ProductJPA();
		dto.setCode(product.getCode());
		dto.setCreate(product.getCreate());
		dto.setDelete(product.getDelete());
		dto.setUpdate(product.getUpdate());
		dto.setUserCreate(product.getUserCreate());
		dto.setUserDelete(product.getUserDelete());
		dto.setUserUpdate(product.getUserUpdate());
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setReference(product.getReference());
		return dto;
	}
	
	public static ParameterJPA convertDtoToJPA(ParameterDto dto) {
		ParameterJPA jpa = new ParameterJPA();
		jpa.setCode(dto.getCode());
		jpa.setCreate(dto.getCreate());
		jpa.setDelete(dto.getDelete());
		jpa.setUpdate(dto.getUpdate());
		jpa.setUserCreate(dto.getUserCreate());
		jpa.setUserDelete(dto.getUserDelete());
		jpa.setUserUpdate(dto.getUserUpdate());
		jpa.setName(dto.getName());
		jpa.setDescription(dto.getDescription());
		jpa.setGroup(dto.getGroup());
		jpa.setValue(dto.getValue());
		return jpa;
	}
	
	public static ParameterDto convertJPAToDto(ParameterJPA jpa) {
		ParameterDto dto = new ParameterDto();
		dto.setCode(jpa.getCode());
		dto.setCreate(jpa.getCreate());
		dto.setDelete(jpa.getDelete());
		dto.setUpdate(jpa.getUpdate());
		dto.setUserCreate(jpa.getUserCreate());
		dto.setUserDelete(jpa.getUserDelete());
		dto.setUserUpdate(jpa.getUserUpdate());
		dto.setName(jpa.getName());
		dto.setDescription(jpa.getDescription());
		dto.setGroup(jpa.getGroup());
		dto.setValue(jpa.getValue());
		return dto;
	}
	
	public static UserJPA convertDtoToJPA(UserDto dto) {
		UserJPA jpa = new UserJPA();
		jpa.setCode(dto.getCode());
		jpa.setCreate(dto.getCreate());
		jpa.setDelete(dto.getDelete());
		jpa.setUpdate(dto.getUpdate());
		jpa.setUserCreate(dto.getUserCreate());
		jpa.setUserDelete(dto.getUserDelete());
		jpa.setUserUpdate(dto.getUserUpdate());
		jpa.setName(dto.getName());
		jpa.setRegister(dto.getRegister());
		jpa.setState(convertDtoToJPA(dto.getState()));
		jpa.setPassword(dto.getPassword());
		return jpa;
	}

	public static MovementDto convertJPAToDto(MovementJPA jpa) {
		MovementDto dto = new MovementDto();
		dto.setCode(jpa.getCode());
		dto.setCreate(jpa.getCreate());
		dto.setDelete(jpa.getDelete());
		dto.setUpdate(jpa.getUpdate());
		dto.setUserCreate(jpa.getUserCreate());
		dto.setUserDelete(jpa.getUserDelete());
		dto.setUserUpdate(jpa.getUserUpdate());
		dto.setMovement(jpa.getUpdate());
		dto.setPucharseValue(jpa.getPucharseValue());
		dto.setSaleValue(jpa.getSaleValue());
		dto.setQuantity(jpa.getQuantity());
		dto.setSummary(convertJPAToDto(jpa.getSummary()));
		dto.setType(convertJPAToDto(jpa.getType()));
		dto.setInOut(jpa.getInOut());
		return  dto;
	}
	
}
