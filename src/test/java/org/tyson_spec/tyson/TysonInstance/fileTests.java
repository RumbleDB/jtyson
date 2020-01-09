package org.tyson_spec.tyson.TysonInstance;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

import junit.framework.TestCase;

public class fileTests extends TestCase {
	
	
	public void testFile() {
		
	

		try {
		    String content = new String(Files.readAllBytes(Paths.get("src/test/java/org/tyson_spec/tyson/TysonInstance/tyson_types.txt")));

			TysonInstance parsedFromFile = TysonInstance.parseFromString(content);
			System.out.println("test tyson instance: " + parsedFromFile);
			
			//number examples
			TysonInstance numberExamples = parsedFromFile.getItem("number-examples");
			//System.out.println("number examples: " + numberExamples);
			BigDecimal testDecimal = new BigDecimal(2);
			assertEquals(testDecimal, numberExamples.getItem("decimal-like-integer").getDecimalValue());			
			
			//string examples
			TysonInstance stringExamples = parsedFromFile.getItem("string-examples");
			//System.out.println("string examples: " + stringExamples);
			assertEquals("hello I am a String :)", stringExamples.getItem("string-annotated").getStringValue());
			assertEquals("hello I am a String :)", stringExamples.getItem("string-not-annotated").getLexicalValue());
			assertTrue(stringExamples.getItem("empty-string-annotated").getStringValue().isEmpty());
			assertEquals("", stringExamples.getItem("empty-string-not-annotated").getStringValue());
			assertTrue(stringExamples.getItem("string-containing-numbers" ).isString());
			
		

			//boolean examples
			TysonInstance booleanExamples = parsedFromFile.getItem("boolean-examples");
			//System.out.println("boolean examples: " + booleanExamples);
			assertTrue(booleanExamples.getItem("true-annotated-quoted").getBooleanValue());
			assertTrue(booleanExamples.getItem("true-annotated-not-quoted").getBooleanValue());
			assertTrue(booleanExamples.getItem("true-not-annotated-not-quoted").getBooleanValue());
			assertTrue(booleanExamples.getItem("true-not-annotated-quoted").isString());

			assertFalse(booleanExamples.getItem("false-annotated-quoted").getBooleanValue());
			assertFalse(booleanExamples.getItem("false-annotated-not-quoted").getBooleanValue());
			assertFalse(booleanExamples.getItem("false-not-annotated-not-quoted").getBooleanValue());
			assertTrue(booleanExamples.getItem("false-not-annotated-quoted").isString());


			//null examples
			TysonInstance nullExamples = parsedFromFile.getItem("null-examples");
			//System.out.println("null" + nullExamples);

			//array examples
			TysonInstance arrayExamples = parsedFromFile.getItem("array-examples");
			//System.out.println("array examples: " + arrayExamples);
			assertEquals(arrayExamples.getItem("array-annotated").toString(), arrayExamples.getItem("array-not-annotated").toString());
			assertEquals(arrayExamples.getItem("nested-array-annotated").toString(), arrayExamples.getItem("nested-array-not-annotated").toString());

			//object examples
			TysonInstance objectExamples = parsedFromFile.getItem("object-examples");
			//System.out.println("object examples: " + objectExamples);
			assertEquals(objectExamples.getItem("object-annotated").toString(),objectExamples.getItem("object-not-annotated").toString());
			assertEquals(objectExamples.getItem("nested-object-annotated").toString(),objectExamples.getItem("nested-object-not-annotated").toString());
			
			//userdefined examples
			TysonInstance userdefinedExamples = parsedFromFile.getItem("userdefined-examples");
			System.out.println("userdefined examples: " + userdefinedExamples);
			System.out.println("userdefined keys: " + userdefinedExamples.getKeys());
			assertTrue(userdefinedExamples.hasKey("userdefined-atomic-integer"));
			
			
			
			TysonInstance userdefined_int = userdefinedExamples.getItem("userdefined-atomic-integer");
			System.out.println("userdefined int: "+ userdefined_int);
			assertEquals("23948209840", userdefined_int.getLexicalValue());
			assertEquals("(\"fantasy-number\")", userdefined_int.getTypeName());

			TysonInstance userdefined_arr = userdefinedExamples.getItem("userdefined-array");
			assertTrue(userdefined_arr.isArray());
			assertEquals("(\"flowers-array\")", userdefined_arr.getTypeName());
			assertEquals("(\"string\")", userdefined_arr.getItem(3).getTypeName());
			assertEquals("Sunflower", userdefined_arr.getItem(3).getStringValue());
			
			TysonInstance userdefined_obj = userdefinedExamples.getItem("userdefined-object");
			assertTrue(userdefined_obj.isObject());
			assertTrue(userdefined_obj.isUserDefinedType());
			assertEquals("(\"flower-colours\")", userdefined_obj.getTypeName());
			assertEquals("purple", userdefined_obj.getItem("Iris").getStringValue());
			
			String zooFile = new String(Files.readAllBytes(Paths.get("src/test/java/org/tyson_spec/tyson/TysonInstance/zoo_example.txt")));

			TysonInstance zoo = TysonInstance.parseFromString(zooFile);
			System.out.println("test tyson instance: " + zoo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}