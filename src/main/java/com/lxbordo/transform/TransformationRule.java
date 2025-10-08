package com.lxbordo.transform;

public interface TransformationRule {
	
	String getName();
	Object apply(Object value);

}
