package com.lxbordo.transform;

public class UpperCaseRule implements TransformationRule {

	@Override
	public String getName() {
		return "UPPERCASE";
	}

	@Override
	public Object apply(Object value) {
		return value instanceof String ? ((String) value).toUpperCase() : value;
	}

}
