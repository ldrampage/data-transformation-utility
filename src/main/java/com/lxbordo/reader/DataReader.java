package com.lxbordo.reader;

import java.io.File;
import java.io.IOException;

public interface DataReader<T> {
	
	T read(File file, Class<T> type) throws IOException;

}
