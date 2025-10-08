package com.lxbordo.transform;

public class TrimRule implements TransformationRule{

	@Override
	public String getName() {
		return "TRIM";
	}

	@Override
	public Object apply(Object value) {
		// TODO Auto-generated method stub
		return value instanceof String ? ((String) value).trim() : value;
	}

}
