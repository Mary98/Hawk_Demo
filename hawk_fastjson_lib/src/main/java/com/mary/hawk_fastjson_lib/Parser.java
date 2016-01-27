package com.mary.hawk_fastjson_lib;

import java.util.List;

public interface Parser {

	String toJson(Object body);

	<T> T fromJson(String content, Class<T> type) throws Exception;
	
	<T> T fromJsonMap(String content, Class<T> type) throws Exception;

	<T> List<T> fromJsonList(String content, Class<T> type) throws Exception;

}
