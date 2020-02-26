package co.com.todo1.procces.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.todo1.interfaces.dto.ProductDto;
import co.com.todo1.todo1.jpa.ProductJPA;

public class JPAUtils {
	static Logger logger = LogManager.getLogger(JPAUtils.class);
	
	public static <D>Boolean isNotBlank(D jpa) {
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
	
	public static ProductDto convertJPAToDto(ProductJPA product) {
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

}
