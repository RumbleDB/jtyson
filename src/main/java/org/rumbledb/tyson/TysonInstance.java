package org.rumbledb.tyson;

import java.math.BigDecimal;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.rumbledb.tyson.antlr.generated.tysonLexer;
import org.rumbledb.tyson.antlr.generated.tysonParser;
import org.rumbledb.tyson.antlr.generated.tysonParser.TysonContext;

/**
 * Represents an instance of a <code>TYSON</code> value and
 * provides basic functionality.
 * 
 * @author 		Diana Steffen
 */

public class TysonInstance {


	/**
	 * Gets the syntactical representation of a <code>TYSON</code> value.
	 * General Method, must be implemented by every <code>TYSON</code> instance class.
	 * 
	 * @return		<code>String</code> which corresponds to the lexical value of this instance
	 */
	public String getLexicalValue() {
		throw new RuntimeException("Not an atomic type");
	}
		
	/**
	 * Checks if a <code>TYSON</code> value is annotated with a user-defined type.
	 * General Method, must be implemented by every <code>TYSON</code> instance class.
	 * 
	 * @return		<code>true</code> if this is a user-defined type, <code>false</code> otherwise
	 */
	public boolean isUserDefinedType(){
		return false;
	}
	
	/**
	 * Gets the name of the type of this value, 
	 * which is either one of the built-in values or a user-defined type name.
	 * General Method, must be implemented by every <code>TYSON</code> instance class.
	 * 
	 * @return		<code>String</code> corresponding to the name of the type of this value.
	 */
	public String getTypeName() {
		throw new RuntimeException("getTypeName() not defined");
	}
	
	/**
	 * Takes a <code>TYSON</code> text in the form of a <code>Java String str</code> and converts it to 
	 * a {@link TysonInstance}. Checks the <code>TYSON</code> text for well-formedness according
	 * to the <code>TYSON</code> specification and checks for validity against built-in
	 * types. 
	 * 
	 * @param str		<code>TYSON</code> text to be parsed
	 * @return			<code>TysonInstance</code> constructed from the input <code>String</code>
	 */
	public static TysonInstance parseFromString(String str) {
    	tysonLexer lexer = new tysonLexer(CharStreams.fromString(str));
    	tysonParser parser = new tysonParser(new CommonTokenStream(lexer));
    	TysonContext tysonCTXT = parser.tyson();
    	JavaTysonVisitor javaTysonVisitor = new JavaTysonVisitor();
    	
    	TysonInstance ty = javaTysonVisitor.visitTyson(tysonCTXT);
    	return ty;
    }
	
	/**
	 * Converts a <code>TysonInstance</code> to its syntactical string representation.
	 */
	@Override
	public String toString() {
		throw new RuntimeException("toString() not defined");
	}

	/**
	 * Checks if a <code>TYSON</code> value is an atomic type.
	 * Must return <code>true</code> for all built-in types except <code>("object")</code> and <code>("array")</code>
	 * and for user-defined atomic types.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 	
	 * @return		<code>true</code> if this is an atomic type, <code>false</code> otherwise
	 */
	public boolean isAtomic() {
		return false;
	}
		
		
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonArray}.
	 * 
	 * @return		<code>true</code> if this is a <code>TysonArray</code>, <code>false</code> otherwise
	 */
	public boolean isArray(){
		return false;
	}
	
	/**
	 * Gets the number of elements in this {@link TysonArray}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		<code>int</code> number of elements
	 */
	public int arraySize() {
		throw new RuntimeException("Not an array type");
	}
	
	/**
	 * Appends a new <code>element</code> at the end of this {@link TysonArray}.
	 * New <code>element</code> needs to be a {@link TysonInstance}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param element	<code>TysonInstance</code> to be appended
	 */
	public void appendElement(TysonInstance element){
		throw new RuntimeException("Not an array type");
	}
	
	
	/**
	 * Gets the element located at the specified <code>index</code>, where
	 * {@link TysonArray} indexing starts at 0.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param index		Position of desired element.
	 * @return			{@link TysonInstance} at position specified by <code>index</code>.
	 */
	public TysonInstance getItem(int index){
		throw new RuntimeException("Not an array type");
	}
	
	
	/**
	 * Sets the element located at the specified <code>index</code> to the new
	 * value provided.
	 * The new element needs to be a {@link TysonInstance}.
	 * {@link TysonArray} indexing starts at 0.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param index		Position of element to be exchanged.
	 * @param newValue	New <code>TysonInstance</code> to be inserted.
	 */
	public void setItem(int index, TysonInstance newValue){
		throw new RuntimeException("Not an array type");
	}
	
	
	
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonBoolean}
	 * 
	 * @return			<code>true</code> if this is a <code>TysonBoolean</code>, <code>false</code> otherwise
	 */
	public boolean isBoolean(){
		return false;
	}
	
	/**
	 * Gets the <code>boolean</code> value of this {@link TysonBoolean}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		<code>boolean</code> value
	 */
	public boolean getBooleanValue() {
		throw new RuntimeException("Not a boolean type");
	}
	
	
	
	
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonDecimal}
	 * 
	 * @return			<code>true</code> if this is a <code>TysonDecimal</code>, <code>false</code> otherwise
	 */
	public boolean isDecimal(){
		return false;
	}
	
	/**
	 * Gets the {@link java.math.BigDecimal} value of this {@link TysonDecimal}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return			<code>BigDecimal</code> value
	 */
	public BigDecimal getDecimalValue() {
		throw new RuntimeException("Not a decimal type");
	}

	
	
	
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonDouble}.
	 * 
	 * @return		<code>true</code> if this is a <code>TysonDouble</code>, <code>false</code> otherwise
	 */
	public boolean isDouble(){
		return false;
	}
	
	/**
	 * Gets the <code>double</code> value of this {@link TysonDouble}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		<code>double</code> value
	 */
	public double getDoubleValue() {
		throw new RuntimeException("Not a double type");
	}

	
	
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonInteger}.
	 * 
	 * @return		<code>true</code> if this is a <code>TysonInteger</code>, <code>false</code> otherwise
	 */
	public boolean isInteger(){
		return false;
	}
	
	/**
	 * Gets the <code>int</code> value of this {@link TysonInteger}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		<code>int</code> value
	 */
	public int getIntegerValue() {
		throw new RuntimeException("Not an integer type");
	}

	
	
	
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonNull}.
	 *
	 * @return		<code>true</code> if this is a <code>TysonNull</code>, <code>false</code> otherwise
	 */
	public boolean isNull(){
		return false;
	}
	
  
	    
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonObject}
	 * 
	 * @return		<code>true</code> if this is a <code>TysonObject</code>, <code>false</code> otherwise
	 */
	public boolean isObject(){
	  	return false;
	}
	
	/**
	 * Gets the number of <code>(key, value)</code> pairs in a {@link TysonObject}.
	 * Throws a RuntimeException if used on instances of other types.
	 * 
	 * @return		<code>int</code> number of <code>(key, value)</code> pairs
	 */
	public int objectSize(){
		throw new RuntimeException("Not an object type");
	}
	
	/**
	 * Gets a <code>String</code> array of all the keys stored in the {@link TysonObject} in the
	 * order in which they were added.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		ordered <code>String</code> array of keys
	 */
	public List<String> getKeys(){
		throw new RuntimeException("Not an object type");
	}
	
	/**
	 * Checks if this {@link TysonObject} includes a pair with the 
	 * given <code>key</code>.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param key		<code>String key</code> name to test existence
	 * @return			<code>boolean</code> answer on key existence
	 */
	public boolean hasKey(String key){
		throw new RuntimeException("Not an object type");
	}
	 
	/**
	 * Gets the item that is associated with the specified <code>key</code>.
	 * Returns <code>null</code> if the <code>key</code> is not found.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param key		<code>String</code> <code>key</code> name to get value from
	 * @return			{@link TysonInstance} associated with specified <code>key</code>
	 */
	public TysonInstance getItem(String key){
		throw new RuntimeException("Not an object type");
	}
	
	/**
	 * Sets the value associated with the specified <code>key</code> to the <code>newValue</code>.
	 * Throws a <code>RuntimeException</code> if the <code>key</code> is not contained in the object.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param key			<code>String</code> <code>key</code> whose associated value is to be changed
	 * @param newValue		{@link TysonInstance} representing new value to be associated with the <code>key</code>
	 */
	public void setItem(String key, TysonInstance newValue){
		throw new RuntimeException("Not an object type");
	}
	
	/**
	 * Adds a new <code>(key, value)</code> pair to this {@link TysonObject}.
	 * If the object previously contained a value associated with the specified <code>key</code>,
	 * the old value is replaced by the specified <code>value</code>.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @param key		<code>key</code> with which the specified <code>value</code> is to be associated
	 * @param value		<code>value</code> to be associated with the specified <code>key</code>
	 */
	public void addPair(String key, TysonInstance value){
		throw new RuntimeException("Not an object type");
	}
	  
	  
	  
	/**
	 * Checks if this {@link TysonInstance} is of type {@link TysonString}
	 * 
	 * @return		<code>true</code> if this is a <code>TysonString</code>, <code>false</code> otherwise
	 */
	public boolean isString(){
		return false;
	}
	
	/**
	 * Gets the <code>String</code> value of this {@link TysonString}.
	 * Throws a <code>RuntimeException</code> if used on instances of other types.
	 * 
	 * @return		<code>String</code> value of this <code>TysonString</code>
	 */
	public String getStringValue() {
		throw new RuntimeException("Not a TysonString type");
	}
		
	
}

