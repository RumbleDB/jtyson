package org.rumbledb.tyson;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.rumbledb.tyson.TysonInstance;

import junit.framework.TestCase;

public class fileTests extends TestCase {
	
	
	public void testFile() {
		
	
		
		try {
		    String content = new String(Files.readAllBytes(Paths.get("src/test/java/org/rumbledb/tyson/tyson_types.txt")));

			TysonInstance parsedFromFile = TysonInstance.parseFromString(content);
			System.out.println("test tyson instance: " + parsedFromFile);
			
			//number examples
			TysonInstance numberExamples = parsedFromFile.getItem("number-examples");
			//System.out.println("number examples: " + numberExamples);
			//integer examples
			TysonInstance integerAnnotated = numberExamples.getItem("integer-annotated");
			TysonInstance integerNotAnnotated = numberExamples.getItem("integer-not-annotated");
			TysonInstance integerAnnotatedQuoted = numberExamples.getItem("integer-annotated-quotes");
			assertEquals("integer", integerAnnotated.getTypeName());
			assertEquals("integer", integerNotAnnotated.getTypeName());
			assertEquals("integer", integerAnnotatedQuoted.getTypeName());
			
			assertEquals(2, integerAnnotated.getIntegerValue());
			assertEquals(2, integerNotAnnotated.getIntegerValue());
			assertEquals(2, integerAnnotatedQuoted.getIntegerValue());
			
			assertEquals("2", integerAnnotated.getLexicalValue());
			assertEquals("2", integerNotAnnotated.getLexicalValue());
			assertEquals("2", integerAnnotatedQuoted.getLexicalValue());
			
			assertTrue(integerAnnotated.isInteger());
			assertTrue(integerNotAnnotated.isInteger());
			assertTrue(integerAnnotatedQuoted.isInteger());

			
			//double examples
			TysonInstance doubleAnotated = numberExamples.getItem("double-annotated");
			TysonInstance doubleNotAnnotated = numberExamples.getItem("double-not-annotated");
			TysonInstance doubleAnnotatedQuoted = numberExamples.getItem("double-annotated-quotes");
			TysonInstance doubleLikeInteger = numberExamples.getItem("double-like-integer");
			TysonInstance doubleNaNAnnotated = numberExamples.getItem("double-NaN-annotated");
			TysonInstance doublePosInfAnnotated = numberExamples.getItem("double-+INF-annotated");
			TysonInstance doubleNegInfAnnotated = numberExamples.getItem("double--INF-annotated");

			assertEquals("double", doubleAnotated.getTypeName());
			assertEquals("double", doubleNotAnnotated.getTypeName());
			assertEquals("double", doubleAnnotatedQuoted.getTypeName());
			assertEquals("double", doubleLikeInteger.getTypeName());
			assertEquals("double", doubleNaNAnnotated.getTypeName());
			assertEquals("double", doublePosInfAnnotated.getTypeName());
			assertEquals("double", doubleNegInfAnnotated.getTypeName());
			
			assertEquals(2e3, doubleAnotated.getDoubleValue());
			assertEquals(2e3, doubleNotAnnotated.getDoubleValue());
			assertEquals(2e3, doubleAnnotatedQuoted.getDoubleValue());
			assertEquals(2.0, doubleLikeInteger.getDoubleValue());
			assertEquals(Double.NaN, doubleNaNAnnotated.getDoubleValue());
			assertEquals(Double.POSITIVE_INFINITY, doublePosInfAnnotated.getDoubleValue());
			assertEquals(Double.NEGATIVE_INFINITY, doubleNegInfAnnotated.getDoubleValue());
			
			assertEquals("2000.0", doubleAnotated.getLexicalValue());
			assertEquals("2000.0", doubleNotAnnotated.getLexicalValue());
			assertEquals("2000.0", doubleAnnotatedQuoted.getLexicalValue());
			assertEquals("2.0", doubleLikeInteger.getLexicalValue());
			assertEquals("NaN", doubleNaNAnnotated.getLexicalValue());
			assertEquals("+INF", doublePosInfAnnotated.getLexicalValue());
			assertEquals("-INF", doubleNegInfAnnotated.getLexicalValue());
			
			assertTrue(doubleAnotated.isDouble());
			assertTrue(doubleNotAnnotated.isDouble());
			assertTrue(doubleAnnotatedQuoted.isDouble());
			assertTrue(doubleLikeInteger.isDouble());
			assertTrue(doubleNaNAnnotated.isDouble());
			assertTrue(doublePosInfAnnotated.isDouble());
			assertTrue(doubleNegInfAnnotated.isDouble());
			
			//decimal examples
			TysonInstance decimalAnnotated = numberExamples.getItem("decimal-annotated");
			TysonInstance decimalNotAnnotated = numberExamples.getItem("decimal-not-annotated");
			TysonInstance decimalAnnotatedQuoted = numberExamples.getItem("decimal-annotated-quotes");
			TysonInstance decimalLikeInteger = numberExamples.getItem("decimal-like-integer");

			assertEquals("decimal", decimalAnnotated.getTypeName());
			assertEquals("decimal", decimalNotAnnotated.getTypeName());
			assertEquals("decimal", decimalAnnotatedQuoted.getTypeName());
			assertEquals("decimal", decimalLikeInteger.getTypeName());
			
			assertEquals(new BigDecimal("2.3"), 	decimalAnnotated.getDecimalValue());
			assertEquals(new BigDecimal("2.3"), 	decimalNotAnnotated.getDecimalValue());
			assertEquals(new BigDecimal("2.3"), 	decimalAnnotatedQuoted.getDecimalValue());
			assertEquals(new BigDecimal("2"), 	decimalLikeInteger.getDecimalValue());
			
			assertEquals("2.3", decimalAnnotated.getLexicalValue());
			assertEquals("2.3", decimalNotAnnotated.getLexicalValue());
			assertEquals("2.3", decimalAnnotatedQuoted.getLexicalValue());
			assertEquals("2", decimalLikeInteger.getLexicalValue());
			
			assertTrue(decimalAnnotated.isDecimal());
			assertTrue(decimalNotAnnotated.isDecimal());
			assertTrue(decimalAnnotatedQuoted.isDecimal());
			assertTrue(decimalLikeInteger.isDecimal());
			
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
			assertEquals("fantasy-number", userdefined_int.getTypeName());

			TysonInstance userdefined_arr = userdefinedExamples.getItem("userdefined-array");
			assertTrue(userdefined_arr.isArray());
			assertEquals("flowers-array", userdefined_arr.getTypeName());
			assertEquals("string", userdefined_arr.getItem(3).getTypeName());
			assertEquals("Sunflower", userdefined_arr.getItem(3).getStringValue());
			
			TysonInstance userdefined_obj = userdefinedExamples.getItem("userdefined-object");
			assertTrue(userdefined_obj.isObject());
			assertTrue(userdefined_obj.isUserDefinedType());
			assertEquals("flower-colours", userdefined_obj.getTypeName());
			assertEquals("purple", userdefined_obj.getItem("Iris").getStringValue());
			
			
			
			String zooFile = new String(Files.readAllBytes(Paths.get("src/test/java/org/rumbledb/tyson/zoo_example.txt")));

			TysonInstance zoo = TysonInstance.parseFromString(zooFile);
			
			Files.writeString(Paths.get("src/test/java/org/rumbledb/tyson/written_file.txt"), zoo.toString());
			System.out.println("test tyson instance: " + zoo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}