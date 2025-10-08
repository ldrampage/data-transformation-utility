package com.lxbordo.transform;

import java.util.List;
import java.util.Map;

import com.lxbordo.util.ReflectionMapper;

public class TransformEngine {
	
	private final Map<String, List<TransformationRule>> rulesByField;
	
	public TransformEngine(Map<String, List<TransformationRule>> rulesByField) {
		this.rulesByField = rulesByField;
	}
	
	public <T> void applyTransformation(T obj) {
		rulesByField.forEach((fieldName, rules) -> {
			ReflectionMapper.getFieldValue(obj, fieldName).ifPresent(value -> {
				Object transformed = value;
				for(TransformationRule rule : rules) {
					transformed = rule.apply(transformed);
				}
				ReflectionMapper.setFieldValue(obj, fieldName, transformed);
			});
		});
	}

}
