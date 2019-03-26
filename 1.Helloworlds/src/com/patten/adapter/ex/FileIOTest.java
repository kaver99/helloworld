package com.patten.adapter.ex;

import java.io.IOException;

public interface FileIOTest {
	public void readFromFile(String filename) throws IOException;
	public void writeToFile(String filename) throws IOException;
	public void setValue(String key, String value);
	public String getValue(String key);
}
