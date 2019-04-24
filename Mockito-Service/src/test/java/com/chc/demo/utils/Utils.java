package com.chc.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	public  String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objMapper = new ObjectMapper();
		return objMapper.writeValueAsString(obj);
	}

}
