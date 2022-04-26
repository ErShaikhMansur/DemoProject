package com.man.utility;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	JsonUtil() {
		throw new IllegalStateException("JsonUtils class");
	}
	
	//Convert Object to Json
 public static Object convertFromObjectToJson(Object obj) throws JsonProcessingException {
	 ObjectMapper mapper=new ObjectMapper();
	 mapper.setVisibility(PropertyAccessor.FIELD,JsonAutoDetect.Visibility.ANY);
	 return mapper.writeValueAsString(obj);
	 
 }
}
