package com.patten.adapter.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIOTest {

	private static final long serialVersionUID = 2120987415967605331L;

	@Override
	public void readFromFile(String filename) throws IOException {
		super.load(new FileInputStream(filename));
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		super.store(new FileOutputStream(filename), "written by FileProperties");
	}

	@Override
	public void setValue(String key, String value) {
		super.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		return super.getProperty(key);
	}

}
