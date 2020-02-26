package co.com.todo1.kardex.abstracts;

import java.lang.reflect.InvocationTargetException;

import co.com.todo1.kardex.pojo.APOJO;
import co.com.todo1.kardex.pojo.MovementResponsePOJO;
import co.com.todo1.utils.utils.I18n;

public class ASvc {

	protected <E extends Exception,P extends APOJO>P errorReturn(E error,Class<P> clazz) {
		try {
			P instance = clazz.getConstructor().newInstance();
			instance.setStatus(error.getMessage());
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			
		}
		return null;
	}
	
	protected <E extends Exception,P extends APOJO>P errorReturn(String error,Class<P> clazz) {
		try {
			P instance = clazz.getConstructor().newInstance();
			instance.setStatus(error);
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
		
		}
		return null;
	}
	
	protected String i18n(String key) {
		return i18n().get(key);
	}
	
	protected I18n i18n() {
		return I18n.INSTANCE();
	}
	
}
