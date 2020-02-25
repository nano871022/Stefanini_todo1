package co.com.todo1.utils.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
	private Locale current;
	private ResourceBundle resource;
	private static I18n i18n;
	private boolean reload;
	private I18n() {}
	public static I18n INSTANCE() {
		if(i18n == null) {
			i18n = new I18n();
		}
		return i18n;
	}
	private void load() {
		current = new Locale(Locale.getDefault().getDisplayLanguage(Locale.getDefault()));
		resource = ResourceBundle.getBundle("MessagesBundle",current);
	}
	
	public String get(String key) {
		if((current == null && resource == null) || reload){
			load();
			reload = false;
		}
		return resource.getString(key);
	}
	
	public String get(String key,Object[] values) {
		return MessageFormat.format(get(key), values);
	}
	
	public I18n changeLoacate(String language,String country) {
		current = new Locale(language,country);
		return this;
	}
	
	public I18n reload() {
		reload = true;
		return this;
	}
}
