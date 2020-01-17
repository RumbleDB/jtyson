package org.rumbledb.tyson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

public class performanceTest extends TestCase {
	
	public void testByLine() {
	
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(
				"src/test/java/org/rumbledb/tyson/LineByLineTests.txt"));	
		
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			// read next line
			line = reader.readLine();
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
