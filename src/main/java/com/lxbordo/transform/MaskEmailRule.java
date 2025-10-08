package com.lxbordo.transform;

public class MaskEmailRule implements TransformationRule {

	@Override
	public String getName() {
		return "MASK_EMAIL";
	}

	@Override
	public Object apply(Object value) {
		if(value instanceof String) {
			String email = (String) value;
			if(email.contains("@")) {
				return email.replaceAll("(?<=.).(?=[^@]*?@)", "*");
			}
			return email;
		}
		return value;
	}

}
