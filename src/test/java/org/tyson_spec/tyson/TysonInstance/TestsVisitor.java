package org.tyson_spec.tyson.TysonInstance;


import java.math.BigDecimal;

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
		
		// Create TysonInteger test values
		String tyInt = "(\"integer\") 1";
		TysonInstance testInt = TysonInstance.parseFromString(tyInt);
		
		String tyIntQuotes = "(\"integer\") \"1\"";
		TysonInstance testInt2 = TysonInstance.parseFromString(tyIntQuotes);
				
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

    	
	}
	
	/**
	 * Tests {@link TysonDecimal} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testDecimal() {
		
		//Create TysonDecimal test values
		String tyDecimal = "(\"decimal\") 2.2";
		TysonInstance testDecimal = TysonInstance.parseFromString(tyDecimal);
		
		String tyDecimal2 = "(\"decimal\") \"2.2\"";
		TysonInstance testDecimal2 = TysonInstance.parseFromString(tyDecimal2);
    	
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

	}

	/**
	 * Tests {@link TysonDouble} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testDouble() {
    	
		// Create TysonDouble test values
		String tyDouble = "(\"double\") 3e6";
		TysonInstance testDouble = TysonInstance.parseFromString(tyDouble);
		
		String tyDouble2 = "(\"double\") \"3e6\"";
		TysonInstance testDouble2 = TysonInstance.parseFromString(tyDouble2);
		
		String tyDouble3 = "(\"double\") \"+INF\"";
		TysonInstance testDouble3 = TysonInstance.parseFromString(tyDouble3);
		System.out.println(testDouble3);
		
		String tyDouble4 = "(\"double\") \"-INF\"";
		TysonInstance testDouble4 = TysonInstance.parseFromString(tyDouble4);
		System.out.println(testDouble4);
		
		String tyDouble5 = "(\"double\") \"NaN\"";
		TysonInstance testDouble5 = TysonInstance.parseFromString(tyDouble5);
		System.out.println(testDouble5);
		
    	
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

    	
	}
	
	/**
	 * Tests {@link TysonNull} parsing works.
	 */
	public void testNull() {
    	
		// Create TysonNull test values
		String tyNull = "(\"null\") null";
		TysonInstance testNull = TysonInstance.parseFromString(tyNull);

    	assertEquals(true, testNull.isNull());
    	assertEquals(false, testNull.isInteger());
    	assertEquals("null", testNull.getLexicalValue());
    	assertEquals("(\"null\")", testNull.getTypeName());
    	
    	assertTrue(testNull.isAtomic());


	}
	
	/**
	 * Tests {@link TysonBoolean} parsing works with quoted and 
	 * unquoted values and gives the same result.
	 */
	public void testBoolean() {
		
		// Create TysonBoolean test values
		String tyBool = "(\"boolean\") true";
		TysonInstance testBool = TysonInstance.parseFromString(tyBool);
		
		String tyBool2 = "(\"boolean\") false";
		TysonInstance testBool2 = TysonInstance.parseFromString(tyBool2);
    	    	
    	assertEquals(true, testBool.getBooleanValue());
    	assertEquals("true", testBool.getLexicalValue());
    	assertEquals(true, testBool.isBoolean());
    	assertEquals(false, testBool.isDecimal());
    	
    	assertEquals(tyBool, testBool.toString());
    	    	
    	assertEquals(false, testBool2.getBooleanValue());
    	assertEquals("false", testBool2.getLexicalValue());
    	assertEquals(true, testBool2.isBoolean());
    	assertEquals(false, testBool2.isDecimal());
    	
    	assertEquals(tyBool2, testBool2.toString());
    	
    	assertTrue(testBool.isAtomic());


	}
	
	/**
	 * Tests {@link TysonArray} parsing works for empty and full arrays.
	 */
	public void testArray() {
		
		// Create TysonArray test values
		String tyArray = "(\"array\") []";
		TysonInstance testArray = TysonInstance.parseFromString(tyArray);
		
		String tyArray2 = "(\"array\") [(\"string\") \"hello\", (\"boolean\") false]";
		TysonInstance testArray2 = TysonInstance.parseFromString(tyArray2);
    	
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
    
	}
	
	
	/**
	 * Tests {@link TysonString} parsing works.
	 */
	public void testString() {
		
		// Create TysonString test values
		String tyString = "(\"string\") \"hello\"";
		TysonInstance testString = TysonInstance.parseFromString(tyString);
		
		assertEquals(false, testString.isDecimal());
    	assertEquals(true, testString.isString());
    	assertEquals("hello", testString.getStringValue());
    	assertEquals("hello", testString.getLexicalValue());
    	
    	assertTrue(testString.isAtomic());
    	
	}
	
	/**
	 * Tests {@link TysonObject} parsing works.
	 */
	public void testObject() {
		
		// Create TysonString test values
		String tyString = "(\"string\") \"hello\"";
		TysonInstance testString = TysonInstance.parseFromString(tyString);
		
		// Create TysonNull test values
		String tyNull = "(\"null\") null";
		TysonInstance testNull = TysonInstance.parseFromString(tyNull);
		
		// Create TysonObject test values
		String big_example = "(\"object\") {\n" + 
				"  \"a\" : (\"array\") [ (\"integer\") 1, (\"decimal\") 2.2, (\"double\") 3e6, (\"string\") \"hello\"],\n" + 
				"  \"b\" : (\"null\") null,\n" + 
				"  \"c\" : (\"boolean\") true,\n" + 
				"  \"d\" : (\"object\") {\n" + 
				"    \"e\" : (\"boolean\") false\n" + 
				"  }\n" + 
				"}";
		TysonInstance big_test = TysonInstance.parseFromString(big_example);
		
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
    	
	}
	
	/**
	 * Tests {@link TysonUserDefinedAtomic} parsing works.
	 */
    public void testUDTAtomic() {
    	
    	// Create TysonUserDefinedAtomic test values
    	String udt = "(\"my-atomic-type\") \"1.4\"";
    	TysonInstance Tudt = TysonInstance.parseFromString(udt);
    	
    	assertEquals(true, Tudt.isUserDefinedType());
    	assertEquals(true, Tudt.isAtomic());
    	
    	assertEquals("1.4", Tudt.getLexicalValue());
    	
    }
    
    /**
	 * Tests {@link TysonUserDefinedArray} parsing works.
	 */
    public void testUDTArray() {
    	
    	//TODO: implement UDTarray tests
    }
    
    /**
   	 * Tests {@link TysonUserDefinedObject} parsing works.
   	 */
    public void testUDTObject() {
    	
    	// Create TysonUserDefinedObject test values
    	String big_udt = "(\"my-object\") {\n" + 
    			" \"Employee-0342F\" : (\"employee-data\") [\n" + 
    			"  		(\"employee-name\") \"Karl\", \n" + 
    			"  		(\"employee-age\") \"32\", \n" + 
    			"    	(\"employee-function\") \"unit tester\"\n" + 
    			"  		]\n" + 
    			"   }";
    	TysonInstance Tbig_udt = TysonInstance.parseFromString(big_udt);
    	
	   	assertEquals(true, Tbig_udt.isUserDefinedType());
       	assertEquals(true, Tbig_udt.isUserDefinedType());
       	assertEquals(true, Tbig_udt.isObject());
       	assertEquals(true, Tbig_udt.getItem("Employee-0342F").isUserDefinedType());
       	assertEquals("(\"my-object\")", Tbig_udt.getTypeName());
       	
       	System.out.println(Tbig_udt);
       	
    }
    
    /**
     * Tests that mismatched types throw an Exception
     */
    public void testTypeMismatch() {
    	String mismatched1 = "(\"integer\") 1.1";
    	
    	boolean thrown = false;
  	  	try {
  	  		TysonInstance m1 = TysonInstance.parseFromString(mismatched1);
  	  	} catch (RuntimeException e) {
  	  		thrown = true;
  	  	}
  	  	assertTrue(thrown); 
	  	
	  	String mismatched12 = "(\"double\") \"test\"";
  	  	thrown = false;
	  	try {
	  		TysonInstance m12 = TysonInstance.parseFromString(mismatched12);
	  	} catch (RuntimeException e) {
	  		thrown = true;
	  	}
	  	assertTrue(thrown); 
  	  	
	  	String mismatched13 = "(\"null\") \"test\"";
  	  	thrown = false;
	  	try {
	  		TysonInstance m13 = TysonInstance.parseFromString(mismatched13);
	  	} catch (RuntimeException e) {
	  		thrown = true;
	  	}
	  	assertTrue(thrown); 
  	  	
  	  	
  	  	//examples from https://github.com/ghislainfourny/tyson-tutorial/blob/master/README.md
  	  	//and http://www.tyson-spec.org/publish/en-US/TYSON/0.9.3/html-single/TYSON/index.html#idm129
  	  	String mismatched2 = "(\"string\") {}";
  	  	String mismatched3 = "(\"array\") \"foo\"";
  	  	String mismatched4 = "(\"boolean\") \"bar\"";
  	  	String mismatched5 = "(\"boolean\") \"yes\"";
  	  	String mismatched6 = "(\"integer\") { \"foo\" : \"bar\" }";
  	  	String mismatched7 = "(\"array\") { \"foo\" : \"bar\" }";
  	  	String mismatched8 = "(\"integer\") \"foo\"";
  	  	String mismatched9 = "(\"integer\") \"2.0\"";
  	  	String mismatched10 = "(\"object\") true";
  	  	
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
    }
    
    public void testUnannotated() {
    	
    	// Create unannotated JSON test values
    	String big_example_NA = " {\n" + 
    			"  \"a\" :  [ 1, 2.2, 3e6, \"hello\"],\n" + 
    			"  \"b\" : 	null,\n" + 
    			"  \"c\" : 	true,\n" + 
    			"  \"d\" : 	{\n" + 
    			"    \"e\" :	false\n" + 
    			"  }\n" + 
    			"}";
    	TysonInstance big_unannotated = TysonInstance.parseFromString(big_example_NA);
    	
    	//System.out.println(big_test);
    	
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
    	
    	System.out.println("big unannotated " + big_unannotated);
    	
    	TysonInstance testNull = TysonInstance.parseFromString("null");
    	big_unannotated.getItem("d").setItem("e", testNull);
    	
    	big_unannotated.getItem("d").addPair("f", testNull);
    	assertEquals(true, big_unannotated.getItem("d").getItem("f").isNull());
    	System.out.println("test " + big_unannotated.getItem("l"));
    	
    	
    }
    
    
    /**
     * Tests that functions called on the wrong instance throw an exception
     */
    public void testCallFunctionsOnWrongInstance() {
    	
    	String str = "(\"string\") \"hello\"";
    	TysonInstance TString = TysonInstance.parseFromString(str);
    	
    	String int1 = "(\"integer\") 42";
    	TysonInstance TInt = TysonInstance.parseFromString(int1);
    	
    	String decimal1 = "(\"decimal\") 42.22";
    	TysonInstance TD = TysonInstance.parseFromString(decimal1);
    	
    	String array1 = "(\"array\") [1,2,3]";
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
    }
    
    
    /**
     * tests all examples specified as valid in the specification are correctly parsed
     */
    public void testSpecExamples() {
    	
    	
    	String accept01 = "(\"my-array\") { \"foo\" : \"bar\" }";
    	TysonInstance a01 = TysonInstance.parseFromString(accept01);
    	assertEquals(true, a01.isUserDefinedType());
    	assertEquals(true, a01.isObject());
    	
    	String accept02 = "(\"boolean\") \"true\"";
    	TysonInstance a02 = TysonInstance.parseFromString(accept02);
    	assertEquals(true, a02.isBoolean());
    	
    	String accept03 = "(\"string\") false";
    	TysonInstance a03 = TysonInstance.parseFromString(accept03);
    	assertEquals(true, a03.isString());;
    	
    	String accept04 = "(\"string\") null";
    	TysonInstance a04 = TysonInstance.parseFromString(accept04);
    	assertEquals(true, a04.isString());
    	
    	String accept05 = "(\"integer\") \"2\"";
    	TysonInstance a05 = TysonInstance.parseFromString(accept05);
    	assertEquals(true, a05.isInteger());
    	
    	String test01 = "(\"customType\") {\n" + 
    			"  \"a\" : (\"date\") \"2018-05-28\",\n" + 
    			"  \"b\" : (\"my-array-type\") [ (\"int\") 1, (\"short\") 2, 3, (\"zipcode\") 8000 ],\n" + 
    			"  \"c\" : (\"xyType\") {\n" + 
    			"    \"x\" : \"xxx\",\n" + 
    			"    \"y\" : (\"myString\") \"yyy\",\n" + 
    			"    \"z\" : (\"string\") true\n" + 
    			"  },\n" + 
    			"  \"d\" : [ \"foo\", \"bar\", true, (\"boolean\") \"false\"]\n" + 
    			"  }";
    	TysonInstance ty01 = TysonInstance.parseFromString(test01);
    	assertEquals(true, a01.isObject());
    	System.out.println(ty01);

    	String json = "{\n" + 
    			"  \"a\" : [ 1, 2.2, 3e6],\n" + 
    			"  \"b\" : null,\n" + 
    			"  \"c\" : true,\n" + 
    			"  \"d\" : {\n" + 
    			"    \"e\" : false\n" + 
    			"  }\n" + 
    			"}";
    	TysonInstance Tjson = TysonInstance.parseFromString(json);
    	
    	String json_annotated = "(\"object\") {\n" + 
    			"  \"a\" : (\"array\") [ (\"integer\") 1, (\"decimal\") 2.2, (\"double\") 3e6],\n" + 
    			"  \"b\" : (\"null\") null,\n" + 
    			"  \"c\" : (\"boolean\") true,\n" + 
    			"  \"d\" : (\"object\") {\n" + 
    			"    \"e\" : (\"boolean\") false\n" + 
    			"  }\n" + 
    			"}";
    	TysonInstance Tjson_annotated = TysonInstance.parseFromString(json_annotated);
    	
    	String json_annotated_quoted = "(\"object\") {\n" + 
    			"  \"a\" : (\"array\") [ (\"integer\") \"1\", (\"decimal\") \"2.2\", (\"double\") \"3e6\"],\n" + 
    			"  \"b\" : (\"null\") \"null\",\n" + 
    			"  \"c\" : (\"boolean\") \"true\",\n" + 
    			"  \"d\" : (\"object\") {\n" + 
    			"    \"e\" : (\"boolean\") \"false\"\n" + 
    			"  }\n" + 
    			"}";
    	TysonInstance Tjson_annotated_quoted = TysonInstance.parseFromString(json_annotated_quoted);
    	
    	assertEquals(Tjson.toString(), Tjson_annotated.toString());
    	assertEquals(Tjson_annotated.toString(), Tjson_annotated_quoted.toString());
    	
    	assertEquals(Tjson.getItem("d").toString(), Tjson_annotated.getItem("d").toString());
    	assertEquals(Tjson_annotated.getItem("d").toString(), Tjson_annotated_quoted.getItem("d").toString());
    	
    	String ty = "(\"boolean\") true";
    	TysonInstance tbool = TysonInstance.parseFromString(ty);
    	
    	Tjson.setItem("b", tbool);
    	Tjson_annotated.setItem("b", tbool);
    	Tjson_annotated_quoted.setItem("b", tbool);
    	assertEquals(Tjson.getItem("b").toString(), Tjson_annotated.getItem("b").toString());
    	assertEquals(Tjson_annotated.getItem("b").toString(), Tjson_annotated_quoted.getItem("b").toString());
    	assertTrue(Tjson.getItem("b").getBooleanValue());
    	assertTrue(Tjson_annotated.getItem("b").getBooleanValue());
    	assertTrue(Tjson_annotated_quoted.getItem("b").getBooleanValue());
    	
    	System.out.println("json1: " + Tjson);
    	System.out.println("json2: " + Tjson_annotated);
    	System.out.println("json3: " + Tjson_annotated_quoted);
    }
   
    /**
     * Some more test examples on numbers.
     */
    public void testExamples() {
    	String accept01 = "(\"decimal\") 2.0";
    	TysonInstance a01 = TysonInstance.parseFromString(accept01);
    	assertEquals(true, a01.isDecimal());
    	System.out.println(a01);

    	
    	String accept02 = "(\"double\") \"2e3\"";
    	TysonInstance a02 = TysonInstance.parseFromString(accept02);
    	assertEquals(true, a02.isDouble());
    	System.out.println(a02);

    	
    	String accept03 = "(\"string\") 2e3";
    	TysonInstance a03 = TysonInstance.parseFromString(accept03);
    	assertEquals(true, a03.isString());
    	System.out.println(a03);

    	
    	String reject01 = "(\"decimal\") \"2e3\"";
    	boolean thrown = false;
	  	try {
	  		TysonInstance r01 = TysonInstance.parseFromString(reject01);
	  	} catch (RuntimeException e) {
	  		thrown = true;
	  	}
	  	assertTrue(thrown); 
	  	
	  	String reject02 = "(\"double\") \"2.3\"";
    	thrown = false;
	  	try {
	  		TysonInstance r02 = TysonInstance.parseFromString(reject02);
	  	} catch (RuntimeException e) {
	  		thrown = true;
	  	}
	  	assertTrue(thrown); 
    	
    }
    
    
 

    
   
}


