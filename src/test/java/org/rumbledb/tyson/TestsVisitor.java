package org.rumbledb.tyson;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import org.rumbledb.tyson.JavaTysonVisitor;
import org.rumbledb.tyson.TysonArray;
import org.rumbledb.tyson.TysonBoolean;
import org.rumbledb.tyson.TysonDecimal;
import org.rumbledb.tyson.TysonDouble;
import org.rumbledb.tyson.TysonInstance;
import org.rumbledb.tyson.TysonInteger;
import org.rumbledb.tyson.TysonNull;
import org.rumbledb.tyson.TysonObject;
import org.rumbledb.tyson.TysonString;
import org.rumbledb.tyson.TysonUserDefinedArray;
import org.rumbledb.tyson.TysonUserDefinedAtomic;
import org.rumbledb.tyson.TysonUserDefinedObject;

import junit.framework.TestCase;

/**
 * Provides unit tests for the {@link JavaTysonVisitor}.
 */
public class TestsVisitor extends TestCase {
	
	
	/**
	 * Tests {@link TysonInteger} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testInteger() {
		System.out.println("TESTING INTEGERS:");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/IntegerTests.txt"));	
			
			String integerString1 = reader.readLine();
			TysonInstance testInt = TysonInstance.parseFromString(integerString1);

			String integerString2 = reader.readLine();
			TysonInstance testInt2 = TysonInstance.parseFromString(integerString2);

			assertEquals(1, testInt.getIntegerValue());
	    	assertEquals("1", testInt.getLexicalValue());
	    	assertEquals(true, testInt.isInteger());
	    	assertEquals("(\"integer\")", testInt.getTypeName());
	    	assertEquals(true, testInt.isAtomic());
	    	assertEquals(false, testInt.isDouble());

	    	assertEquals(1, testInt2.getIntegerValue());
	    	assertEquals("1", testInt2.getLexicalValue());
	    	assertEquals(true, testInt2.isInteger());
	    	assertEquals("(\"integer\")", testInt2.getTypeName());
	    	assertEquals(true, testInt2.isAtomic());
	    	
	    	assertEquals(testInt.toString(), testInt2.toString());
	    	
	    	assertTrue(testInt.isAtomic());
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
	
	/**
	 * Tests {@link TysonDecimal} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testDecimal() {
		System.out.println("TESTING DECIMALS:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/DecimalTests.txt"));	
			
			String decimalString1 = reader.readLine();
			TysonInstance testDecimal = TysonInstance.parseFromString(decimalString1);

			String decimalString2 = reader.readLine();
			TysonInstance testDecimal2 = TysonInstance.parseFromString(decimalString2);
			
			
			assertEquals(BigDecimal.valueOf(2.2), testDecimal.getDecimalValue());
	    	assertEquals("2.2", testDecimal.getLexicalValue());
	    	assertEquals(true, testDecimal.isDecimal());
	    	assertEquals("(\"decimal\")", testDecimal.getTypeName());
	    	
	    	assertEquals(BigDecimal.valueOf(2.2), testDecimal2.getDecimalValue());
	    	assertEquals("2.2", testDecimal2.getLexicalValue());
	    	assertEquals(true, testDecimal2.isDecimal());
	    	assertEquals("(\"decimal\")", testDecimal2.getTypeName());
	    	
	    	
	    	assertEquals(testDecimal.toString(), testDecimal2.toString());
	    	
	    	assertTrue(testDecimal.isAtomic());
	    	
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests {@link TysonDouble} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testDouble() {
		System.out.println("TESTING DOUBLES:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/DoubleTests.txt"));	
			
			String doubleString1 = reader.readLine();
			TysonInstance testDouble = TysonInstance.parseFromString(doubleString1);

			String doubleString2 = reader.readLine();
			TysonInstance testDouble2 = TysonInstance.parseFromString(doubleString2);

			String doubleString3 = reader.readLine();
			TysonInstance testDouble3 = TysonInstance.parseFromString(doubleString3);

			String doubleString4 = reader.readLine();
			TysonInstance testDouble4 = TysonInstance.parseFromString(doubleString4);

			String doubleString5 = reader.readLine();
			TysonInstance testDouble5 = TysonInstance.parseFromString(doubleString5);

			assertEquals(3e6, testDouble.getDoubleValue());
	    	assertEquals("3000000.0", testDouble.getLexicalValue());
	    	assertEquals(true, testDouble.isDouble());
	    	assertEquals("(\"double\")", testDouble.getTypeName());
	    	assertEquals(true, testDouble.isAtomic());
	    	
	    	assertEquals(3e6, testDouble2.getDoubleValue());
	    	assertEquals("3000000.0", testDouble2.getLexicalValue());
	    	assertEquals(true, testDouble2.isDouble());
	    	assertEquals("(\"double\")", testDouble2.getTypeName());
	    	assertEquals(true, testDouble2.isAtomic());
	    	
	    	assertEquals(testDouble.toString(), testDouble2.toString());
	    	
	    	assertTrue(testDouble.isAtomic());
	    	
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    
	}
	
	/**
	 * Tests {@link TysonNull} parsing works.
	 */
	public void testNull() {
		System.out.println("TESTING NULL:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/NullTests.txt"));	
			
			String nullString = reader.readLine();
			TysonInstance testNull = TysonInstance.parseFromString(nullString);

			assertEquals(true, testNull.isNull());
	    	assertEquals(false, testNull.isInteger());
	    	assertEquals("null", testNull.getLexicalValue());
	    	assertEquals("(\"null\")", testNull.getTypeName());
	    	
	    	assertTrue(testNull.isAtomic());
	    	
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    
	}
	
	/**
	 * Tests {@link TysonBoolean} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testBoolean() {
		System.out.println("TESTING BOOLEAN:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/BooleanTests.txt"));	
			
			String booleanString1 = reader.readLine();
			TysonInstance testBool = TysonInstance.parseFromString(booleanString1);

			String booleanString2 = reader.readLine();
			TysonInstance testBool2 = TysonInstance.parseFromString(booleanString2);

			assertEquals(true, testBool.getBooleanValue());
	    	assertEquals("true", testBool.getLexicalValue());
	    	assertEquals(true, testBool.isBoolean());
	    	assertEquals(false, testBool.isDecimal());
	    	
	    	assertEquals(booleanString1, testBool.toString());
	    	    	
	    	assertEquals(false, testBool2.getBooleanValue());
	    	assertEquals("false", testBool2.getLexicalValue());
	    	assertEquals(true, testBool2.isBoolean());
	    	assertEquals(false, testBool2.isDecimal());
	    	
	    	assertEquals(booleanString2, testBool2.toString());
	    	
	    	assertTrue(testBool.isAtomic());

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Tests {@link TysonArray} parsing works for empty and full arrays.
	 */
	public void testArray() {
		System.out.println("TESTING ARRAY:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/ArrayTests.txt"));	
			String line1 = reader.readLine();
			TysonInstance testArray = TysonInstance.parseFromString(line1);

			String line2 = reader.readLine();
			TysonInstance testArray2 = TysonInstance.parseFromString(line2);
			
			
			//tests:
			assertEquals(false, testArray.isDecimal());
	    	assertEquals(true, testArray.isArray());
	    	assertEquals(0, testArray.arraySize());
	    	
	    	assertEquals(false, testArray2.isDecimal());
	    	assertEquals(true, testArray2.isArray());
	    	assertEquals(2, testArray2.arraySize());
	    	assertEquals(true, testArray2.getItem(0).isString());
	    	assertEquals(true, testArray2.getItem(1).isBoolean());
	    	
	    	assertFalse(testArray.isAtomic());
	    	
	    	testArray2.setItem(0, testArray);
	    	assertEquals(testArray2.getItem(0), testArray);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
	
	
	/**
	 * Tests {@link TysonString} parsing works.
	 */
	public void testString() {
		System.out.println("TESTING STRINGS:");

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/StringTests.txt"));	
			
			String stringInput01 = reader.readLine();
			String stringInput02 = reader.readLine();
			TysonInstance testString = TysonInstance.parseFromString(stringInput01);
			//TysonInstance testString02 = TysonInstance.parseFromString(stringInput02);

			assertEquals(false, testString.isDecimal());
	    	assertEquals(true, testString.isString());
	    	assertEquals("hello", testString.getStringValue());
	    	assertEquals("hello", testString.getLexicalValue());
	    	
	    	
	    	//assertEquals(true, testString02.isString());
	    	//assertEquals("hello", testString02.getStringValue());
	    	//assertEquals("hello", testString02.getLexicalValue());
	    	
	    	assertTrue(testString.isAtomic());
	    	
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Tests {@link TysonObject} parsing works.
	 */
	public void testObject() {
		System.out.println("TESTING OBJECTS:");
		
		BufferedReader reader;
		try {
			
			// Create TysonString test values
			String tyString = "(\"string\") \"hello\"";
			TysonInstance testString = TysonInstance.parseFromString(tyString);
			
			// Create TysonNull test values
			String tyNull = "(\"null\") null";
			TysonInstance testNull = TysonInstance.parseFromString(tyNull);
			
			
			reader = new BufferedReader(new FileReader(
					"src/test/java/org/rumbledb/tyson/ObjectTests.txt"));	
			
			String objectString = reader.readLine();
			TysonInstance big_test = TysonInstance.parseFromString(objectString);

			assertFalse(big_test.isAtomic());
			
			assertEquals(false, big_test.isBoolean());
	    	assertEquals(4, big_test.objectSize());
	    	assertEquals(true, big_test.hasKey("a"));
	    	assertEquals(true, big_test.getItem("b").isNull());
	    	assertEquals(true, big_test.getItem("a").isArray());
	    	assertEquals(true, big_test.getItem("a").getItem(1).isDecimal());
	    	assertEquals(BigDecimal.valueOf(2.2), big_test.getItem("a").getItem(1).getDecimalValue());
	    	assertEquals("2.2", big_test.getItem("a").getItem(1).getLexicalValue());
	    	
	    	assertEquals(true, big_test.getItem("d").isObject());
	    	assertEquals(1, big_test.getItem("d").objectSize());
	    	
	    	big_test.getItem("d").setItem("e", testString);
	    	
	    	assertEquals(false, big_test.getItem("d").getItem("e").isObject());
	    	assertEquals(true, big_test.getItem("d").getItem("e").isString());
	    	
	    	big_test.getItem("d").addPair("f", testNull);
	    	assertEquals(true, big_test.getItem("d").getItem("f").isNull());
	    	
	    	boolean thrown = false;
	  	  	try {
	  	  		big_test.setItem("ks", testString);	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}
	
	/**
	 * Tests {@link TysonUserDefinedAtomic} parsing works.
	 */
    public void testUDTAtomic() {
		System.out.println("TESTING UDTATOMICS:");

    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/UserdefinedAtomicTests.txt"));	
    		
    		String atomicString = reader.readLine();
        	TysonInstance Tudt = TysonInstance.parseFromString(atomicString);

        	assertEquals(true, Tudt.isUserDefinedType());
        	assertEquals(true, Tudt.isAtomic());
        	
        	assertEquals("1.4", Tudt.getLexicalValue());
        	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    
    }
    
    /**
	 * Tests {@link TysonUserDefinedArray} parsing works.
	 */
    public void testUDTArray() {
		System.out.println("TESTING UDTARRAYS:");

		BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/UserdefinedArrayTests.txt"));	
    		
    		String udaString01 = reader.readLine();
    		TysonInstance udArray01 = TysonInstance.parseFromString(udaString01);
        	assertEquals(3, udArray01.arraySize());
        	assertTrue(udArray01.isUserDefinedType());
        	assertEquals("(\"animals\")", udArray01.getTypeName());
        	assertTrue(udArray01.getItem(0).isString());
    	   	
        	String udaString02 = reader.readLine();
    		TysonInstance udArray02 = TysonInstance.parseFromString(udaString02);
    		assertEquals(0, udArray02.arraySize());
    		TysonInstance animal = TysonFactory.getInstance().createString("ozelot");
    		udArray02.appendElement(animal);
    		System.out.println(udArray02);
    		assertEquals(1, udArray02.arraySize());
    		
    		String udaString03 = reader.readLine();
    		TysonInstance udArray03 = TysonInstance.parseFromString(udaString03);
    		assertEquals(1, udArray03.arraySize());
    		assertEquals("otter", udArray03.getItem(0).getStringValue());
    		udArray03.setItem(0, animal);
    		assertEquals("ozelot", udArray03.getItem(0).getStringValue());
           	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
   	 * Tests {@link TysonUserDefinedObject} parsing works.
   	 */
    public void testUDTObject() {
		System.out.println("TESTING UDTOBJECTS:");

    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/UserdefinedObjectTests.txt"));	
    		
    		String udoString = reader.readLine();
    		TysonInstance Tbig_udt = TysonInstance.parseFromString(udoString);
        	
    	   	assertEquals(true, Tbig_udt.isUserDefinedType());
           	assertEquals(true, Tbig_udt.isUserDefinedType());
           	assertEquals(true, Tbig_udt.isObject());
           	assertEquals(true, Tbig_udt.getItem("Employee-0342F").isUserDefinedType());
           	assertEquals("(\"my-object\")", Tbig_udt.getTypeName());
           	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
       	
    }
    
    /**
     * Tests that mismatched types throw an Exception
     */
    public void testTypeMismatch() {
		System.out.println("TESTING TYPE MISMATCH:");
    	
    	
    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/TypeMismatchTests.txt"));	
    		
    		String mismatched1 = reader.readLine();
    		String mismatched12 = reader.readLine();
    		String mismatched13 = reader.readLine();
    		//examples from https://github.com/ghislainfourny/tyson-tutorial/blob/master/README.md
      	  	//and http://www.tyson-spec.org/publish/en-US/TYSON/0.9.3/html-single/TYSON/index.html#idm129
      	  	String mismatched2 = reader.readLine();
      	  	String mismatched3 = reader.readLine();
      	  	String mismatched4 = reader.readLine();
      	  	String mismatched5 = reader.readLine();
      	  	String mismatched6 = reader.readLine();
      	  	String mismatched7 = reader.readLine();
      	  	String mismatched8 = reader.readLine();
      	  	String mismatched9 = reader.readLine();
      	  	String mismatched10 = reader.readLine();
    		
    		boolean thrown = false;
      	  	try {
      	  		TysonInstance m1 = TysonInstance.parseFromString(mismatched1);
      	  	} catch (RuntimeException e) {
      	  		thrown = true;
      	  	}
      	  	assertTrue(thrown); 

      	  	thrown = false;
	  	  	try {
	  	  		TysonInstance m12 = TysonInstance.parseFromString(mismatched12);
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown); 
      	  	
	  	  	thrown = false;
		  	try {
		  		TysonInstance m13 = TysonInstance.parseFromString(mismatched13);
		  	} catch (RuntimeException e) {
		  		thrown = true;
		  	}
		  	assertTrue(thrown); 
		  	
		  	thrown = false;
	  	  	try {
	  	  		TysonInstance m2 = TysonInstance.parseFromString(mismatched2);  	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown);
	  	  	
	  	  thrown = false;
		  	try {
		  		TysonInstance m3 = TysonInstance.parseFromString(mismatched3);  	  	
		  	} catch (RuntimeException e) {
		  		thrown = true;
		  	}
		  	assertTrue(thrown); 
		  	
		  	thrown = false;
	  	  	try {
	  	  		TysonInstance m4 = TysonInstance.parseFromString(mismatched4);  	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown); 
	  	  	
	  	  thrown = false;
		  	try {
		  		TysonInstance m5 = TysonInstance.parseFromString(mismatched5);  	  	
		  	} catch (RuntimeException e) {
		  		thrown = true;
		  	}
		  	assertTrue(thrown);
		  	
		  	
		  	thrown = false;
	  	  	try {
	  	  		TysonInstance m6 = TysonInstance.parseFromString(mismatched6);  	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown);
	  	  	
	  	  	
	  	  thrown = false;
		  	try {
		  		TysonInstance m7 = TysonInstance.parseFromString(mismatched7);  	  	
		  	} catch (RuntimeException e) {
		  		thrown = true;
		  	}
		  	assertTrue(thrown);
		  	
		  	
		  	thrown = false;
	  	  	try {
	  	  		TysonInstance m8 = TysonInstance.parseFromString(mismatched8);  	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown);
	  	  	
	  	  thrown = false;
		  	try {
		  		TysonInstance m9 = TysonInstance.parseFromString(mismatched9);  	  	
		  	} catch (RuntimeException e) {
		  		thrown = true;
		  	}
		  	assertTrue(thrown);
		  	
		  	thrown = false;
	  	  	try {
	  	  		TysonInstance m10 = TysonInstance.parseFromString(mismatched10);  	  	
	  	  	} catch (RuntimeException e) {
	  	  		thrown = true;
	  	  	}
	  	  	assertTrue(thrown);
	  	  	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
  	  	
    }
    
    public void testUnannotated() {
		System.out.println("TESTING UNANNOTATED:");

    	
    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/UnannotatedTests.txt"));	
    		
    		String big_example_NA = reader.readLine();
        	TysonInstance big_unannotated = TysonInstance.parseFromString(big_example_NA);

        	assertEquals(false, big_unannotated.isBoolean());
        	assertEquals(4, big_unannotated.objectSize());
        	assertEquals(true, big_unannotated.hasKey("a"));
        	assertEquals(true, big_unannotated.getItem("b").isNull());
        	assertEquals(true, big_unannotated.getItem("a").isArray());
        	assertEquals(true, big_unannotated.getItem("a").getItem(1).isDecimal());
        	assertEquals(BigDecimal.valueOf(2.2), big_unannotated.getItem("a").getItem(1).getDecimalValue());
        	assertEquals("2.2", big_unannotated.getItem("a").getItem(1).getLexicalValue());
        	
        	assertEquals(true, big_unannotated.getItem("d").isObject());
        	assertEquals(1, big_unannotated.getItem("d").objectSize());
        	
        	
        	TysonInstance testString = TysonInstance.parseFromString("\"hello\"");
        	big_unannotated.getItem("d").setItem("e", testString);
        	
        	assertEquals(false, big_unannotated.getItem("d").getItem("e").isObject());
        	assertEquals(true, big_unannotated.getItem("d").getItem("e").isString());
        	assertEquals("hello", big_unannotated.getItem("d").getItem("e").getStringValue());
        	
        	//System.out.println("big unannotated " + big_unannotated);
        	
        	TysonInstance testNull = TysonInstance.parseFromString("null");
        	big_unannotated.getItem("d").setItem("e", testNull);
        	
        	big_unannotated.getItem("d").addPair("f", testNull);
        	assertEquals(true, big_unannotated.getItem("d").getItem("f").isNull());
        	//System.out.println("test " + big_unannotated.getItem("l"));
        	
        	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    /**
     * Tests that functions called on the wrong instance throw an exception
     */
    public void testCallFunctionsOnWrongInstance() {
		System.out.println("TESTING MISC:");

    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/MiscTests.txt"));	
    		
    		String str = reader.readLine();
        	TysonInstance TString = TysonInstance.parseFromString(str);

    		String int1 = reader.readLine();
        	TysonInstance TInt = TysonInstance.parseFromString(int1);

    		String decimal1 = reader.readLine();
        	TysonInstance TD = TysonInstance.parseFromString(decimal1);

    		String array1 = reader.readLine();
        	TysonInstance TArray = TysonInstance.parseFromString(array1);

        	boolean thrown = false;
      	  	try {
      	  		TString.arraySize();
      	  	} catch (RuntimeException e) {
      	  		thrown = true;
      	  	}
      	  	assertTrue(thrown); 
      	  	
      	  	thrown = false;
    	  	try {
    	  		TString.getKeys();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getLexicalValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertFalse(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.isString();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertFalse(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TInt.appendElement(TString);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getItem(0);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.setItem(0, TInt);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getBooleanValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getDecimalValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getDoubleValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getIntegerValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    	  	thrown = false;
    	  	try {
    	  		int x = TInt.getIntegerValue();
    	  		assertEquals(42, x);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertFalse(thrown); 
    	  	
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.objectSize();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.hasKey("\"a\"");
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    	  	thrown = false;
    	  	try {
    	  		TString.getItem("\"a\"");
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    		thrown = false;
    	  	try {
    	  		TString.setItem("\"a\"", TInt);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    		thrown = false;
    	  	try {
    	  		TString.addPair("\"a\"", TInt);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    		thrown = false;
    	  	try {
    	  		TInt.getStringValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    	  	thrown = false;
    	  	try {
    	  		TInt.getStringValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    	  	thrown = false;
    	  	try {
    	  		TArray.getLexicalValue();
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown);
    	  	
    	  	assertFalse(TArray.isUserDefinedType());
    		
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}

    }
    
    
    /**
     * tests all examples specified as valid in the specification are correctly parsed
     */
    public void testSpecExamples() {
		System.out.println("TESTING SPECIFICATION EXAMPLES:");

    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/SpecificationExamples.txt"));	
    		
    		String accept01 = reader.readLine();
    		String accept02 = reader.readLine();
    		String accept03 = reader.readLine();
    		String accept04 = reader.readLine();
    		String accept05 = reader.readLine();
    		String test01 = reader.readLine();
    		String json = reader.readLine();
    		String json_annotated = reader.readLine();
    		String json_annotated_quoted = reader.readLine();
    		String ty = reader.readLine();    		
    		
    		TysonInstance a01 = TysonInstance.parseFromString(accept01);
        	assertEquals(true, a01.isUserDefinedType());
        	assertEquals(true, a01.isObject());
        	
         	TysonInstance a02 = TysonInstance.parseFromString(accept02);
        	assertEquals(true, a02.isBoolean());
        	
        	TysonInstance a03 = TysonInstance.parseFromString(accept03);
        	assertEquals(true, a03.isString());;
        	//System.out.println(a03);
        	//System.out.println(a03.getStringValue());
        	//System.out.println(a03.getLexicalValue());

    		
        	TysonInstance a04 = TysonInstance.parseFromString(accept04);
        	assertEquals(true, a04.isString());
        	
        	TysonInstance a05 = TysonInstance.parseFromString(accept05);
        	assertEquals(true, a05.isInteger());
        	
        	TysonInstance ty01 = TysonInstance.parseFromString(test01);
        	assertEquals(true, a01.isObject());
        	//System.out.println(ty01);
        	
        	TysonInstance Tjson = TysonInstance.parseFromString(json);
        	TysonInstance Tjson_annotated = TysonInstance.parseFromString(json_annotated);
        	TysonInstance Tjson_annotated_quoted = TysonInstance.parseFromString(json_annotated_quoted);

        	assertEquals(Tjson.toString(), Tjson_annotated.toString());
        	assertEquals(Tjson_annotated.toString(), Tjson_annotated_quoted.toString());
        	
        	assertEquals(Tjson.getItem("d").toString(), Tjson_annotated.getItem("d").toString());
        	assertEquals(Tjson_annotated.getItem("d").toString(), Tjson_annotated_quoted.getItem("d").toString());
        	
        	TysonInstance tbool = TysonInstance.parseFromString(ty);
        	
        	Tjson.setItem("b", tbool);
        	Tjson_annotated.setItem("b", tbool);
        	Tjson_annotated_quoted.setItem("b", tbool);
        	assertEquals(Tjson.getItem("b").toString(), Tjson_annotated.getItem("b").toString());
        	assertEquals(Tjson_annotated.getItem("b").toString(), Tjson_annotated_quoted.getItem("b").toString());
        	assertTrue(Tjson.getItem("b").getBooleanValue());
        	assertTrue(Tjson_annotated.getItem("b").getBooleanValue());
        	assertTrue(Tjson_annotated_quoted.getItem("b").getBooleanValue());
        	
        	//System.out.println("json1: " + Tjson);
        	//System.out.println("json2: " + Tjson_annotated);
        	//System.out.println("json3: " + Tjson_annotated_quoted);
        	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
   
    /**
     * Some more test examples on numbers.
     */
    public void testExamples() {
		System.out.println("TESTING NUMBERTESTS:");

    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(
    				"src/test/java/org/rumbledb/tyson/NumberTests.txt"));	
    		
    		String accept01 = reader.readLine();
    		String accept02 = reader.readLine();
    		String accept03 = reader.readLine();
    		String reject01 = reader.readLine();
    		String reject02 = reader.readLine();
    		
    		TysonInstance a01 = TysonInstance.parseFromString(accept01);
        	assertEquals(true, a01.isDecimal());
        	//System.out.println(a01);
        	
        	TysonInstance a02 = TysonInstance.parseFromString(accept02);
        	assertEquals(true, a02.isDouble());
        	//System.out.println(a02);
    		
        	TysonInstance a03 = TysonInstance.parseFromString(accept03);
        	assertEquals(true, a03.isString());
        	//System.out.println(a03);
        	
        	boolean thrown = false;
    	  	try {
    	  		TysonInstance r01 = TysonInstance.parseFromString(reject01);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
        	thrown = false;
    	  	try {
    	  		TysonInstance r02 = TysonInstance.parseFromString(reject02);
    	  	} catch (RuntimeException e) {
    	  		thrown = true;
    	  	}
    	  	assertTrue(thrown); 
    	  	
    		reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    }
 
   
}


