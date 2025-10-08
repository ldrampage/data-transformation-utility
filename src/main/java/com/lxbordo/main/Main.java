package com.lxbordo.main;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxbordo.model.Person;
import com.lxbordo.reader.YamlDataReader;
import com.lxbordo.transform.MaskEmailRule;
import com.lxbordo.transform.TransformEngine;
import com.lxbordo.transform.TransformationRule;
import com.lxbordo.transform.TrimRule;
import com.lxbordo.transform.UpperCaseRule;

public class Main {
	
	public static void main(String[] args) throws Exception {
		YamlDataReader<Person> reader = new YamlDataReader<Person>();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		
		Person person = reader.read(new File("src/main/resources/person.yaml"), Person.class);
		
		objectMapper.writeValueAsString(person);

		
		System.out.println(person);
		
		Map<String, List<TransformationRule>> rules = Map.of("name", List.of(new TrimRule(), new UpperCaseRule()),
				"email", List.of(new MaskEmailRule()));
		
		TransformEngine engine = new TransformEngine(rules);
		
		engine.applyTransformation(person);
		
		System.out.println("Transformed: " + objectMapper.writeValueAsString(person));
		
		
	}

}
