package org.rumbledb.tyson;

import java.math.BigDecimal;

import junit.framework.TestCase;

public class serializationTests extends TestCase {

	public void testInstantiation() {
		TysonArray testArray = TysonFactory.getInstance().createArray();
		TysonBoolean testBooleanTrue = TysonFactory.getInstance().createBoolean(true);
		TysonDecimal testDecimal = TysonFactory.getInstance().createDecimal(new BigDecimal(4.9));
		TysonDouble testDouble = TysonFactory.getInstance().createDouble(3e8);
		TysonInteger testInteger = TysonFactory.getInstance().createInteger(8);
		TysonNull testNull = TysonFactory.getInstance().createNull();
		TysonObject testObject = TysonFactory.getInstance().createObject();
		TysonString testString = TysonFactory.getInstance().createString("otter");
		TysonDouble testSpecialValue = TysonFactory.getInstance().createDouble(Double.POSITIVE_INFINITY);
		
		String serializedDouble = testSpecialValue.toString();
		System.out.println("special value is: "+ serializedDouble);
		TysonInstance deserialized = TysonInstance.parseFromString(serializedDouble);
		System.out.println(deserialized);
		System.out.println(deserialized.getLexicalValue());
		
		testArray.appendElement(testBooleanTrue);
		testArray.appendElement(testInteger);
		
		testObject.addPair("int", testInteger);
		testObject.addPair("dec", testDecimal);
		
		TysonUserDefinedAtomic testUDAtomic = TysonFactory.getInstance().createUserDefinedAtomic("myAtomic", testDouble);
		TysonUserDefinedArray testUDA = TysonFactory.getInstance().createUserDefinedArray("myArray", testArray);
		TysonUserDefinedObject testUDO = TysonFactory.getInstance().createUserDefinedObject("myObject", testObject);
		
		assertEquals("(\"array\") [ (\"boolean\") true, (\"integer\") 8 ]", testArray.toString());
		assertEquals("(\"boolean\") true", testBooleanTrue.toString());
		assertEquals("(\"decimal\") 4.9000000000000003552713678800500929355621337890625", testDecimal.toString());
		assertEquals("(\"double\") 3.0E8", testDouble.toString());
		assertEquals("(\"integer\") 8", testInteger.toString());
		assertEquals("(\"null\") null", testNull.toString());
		assertEquals("(\"object\") { \"int\" : (\"integer\") 8, \"dec\" : (\"decimal\") 4.9000000000000003552713678800500929355621337890625 }", testObject.toString());
		assertEquals("(\"string\") \"otter\"", testString.toString());
		assertEquals("(\"myAtomic\") \"3.0E8\"", testUDAtomic.toString());
		assertEquals("(\"myArray\") [ (\"boolean\") true, (\"integer\") 8 ]", testUDA.toString());
		assertEquals("(\"myObject\") { \"int\" : (\"integer\") 8, \"dec\" : (\"decimal\") 4.9000000000000003552713678800500929355621337890625 }", testUDO.toString());
		
		System.out.println(testArray);
		System.out.println(testBooleanTrue);
		System.out.println(testDecimal);
		System.out.println(testDouble);
		System.out.println(testInteger);
		System.out.println(testNull);
		System.out.println(testObject);
		System.out.println(testString);
		System.out.println(testUDAtomic);
		System.out.println(testUDA);
		System.out.println(testUDO);
		
	}
}