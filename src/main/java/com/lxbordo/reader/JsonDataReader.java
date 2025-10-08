package com.lxbordo.reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataReader<T> implements DataReader<T> {
	
    private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public T read(File file, Class<T> type) throws IOException {
		return this.mapper.readValue(file, type);
	}
	
	

}
