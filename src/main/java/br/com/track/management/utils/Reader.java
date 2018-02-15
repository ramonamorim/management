package br.com.track.management.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

public class Reader {

	public Stream<String> readFile(String resourceFileName) {

		try {

			InputStream is = getClass().getClassLoader().getResourceAsStream(resourceFileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			return reader.lines();
		} catch (Error e) {
			throw new RuntimeErrorException(e);
		}
	}
}
