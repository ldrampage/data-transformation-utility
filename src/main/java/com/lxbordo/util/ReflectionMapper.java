package com.lxbordo.util;

import java.lang.reflect.Field;
import java.util.Optional;

public class ReflectionMapper {
	
	public static Optional<Object> getFieldValue(Object target, String fieldName) {
		
		try {
			
			Field field = target.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return Optional.ofNullable(field.get(target));
			
		} catch(Exception e) {
			return Optional.empty();
		}
		
	}
	
	public static void setFieldValue(Object target, String fieldName, Object value) {
		try {
			
			Field field = target.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(target, value);
			
		} catch(Exception e) {
			throw new RuntimeException("Failed to set field value ", e);
		}
	}

}
