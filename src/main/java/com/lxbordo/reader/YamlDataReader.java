package com.lxbordo.reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class YamlDataReader<T> implements DataReader<T> {
	
	private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

	@Override
	public T read(File file, Class<T> type) throws IOException {
		return mapper.readValue(file, type);
	}

}
