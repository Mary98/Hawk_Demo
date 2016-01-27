package com.mary.hawk_gson_lib;

import java.lang.reflect.Type;

public interface Parser {

  <T> T fromJson(String content, Type type) throws Exception;

  String toJson(Object body);

}
