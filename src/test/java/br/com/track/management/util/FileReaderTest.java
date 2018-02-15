package br.com.track.management.util;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import br.com.track.management.utils.FileReader;



public class FileReaderTest {
	
	@Test
	public void readFileTest() {
		assertNotNull(new FileReader().readFile("input.txt"));
	}
}
