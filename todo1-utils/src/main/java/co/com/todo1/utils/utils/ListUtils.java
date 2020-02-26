package co.com.todo1.utils.utils;

import java.util.List;

import co.com.todo1.kardex.abstracts.ADto;

public class ListUtils {
	
  public final static <D extends ADto>Boolean isNotEmpty(List<D> list) {
	  return list != null && list.size()>0;
  }
}
