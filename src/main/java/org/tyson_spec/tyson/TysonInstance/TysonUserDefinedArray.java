package org.tyson_spec.tyson.TysonInstance;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the <code>TYSON</code> user-defined array value.
 * Extends the {@link TysonArray} class.
 * 
 * @author 		Diana Steffen
 */
public class TysonUserDefinedArray extends TysonArray{

	/**
	 * Holds the user-defined name for this TYSON array
	 * which must be different from all built-in type names.
	 * The type name must correspond to a <code>JSON string</code>.
	 */
	String typeName;

	
	
	/**
	 * Constructs an instance of the {@link TysonUserDefinedArray} class.
	 * Checks if the provided type name is one of the built-in type names
	 * and throws a <code>RuntimeException</code> if this is the case, as user-defined type
	 * names must be different from built-in type names.
	 * Sets the type name according to the provided name and the 
	 * value according to the provided {@link TysonInstance}.
	 * 
	 * @param name		<code>String</code> name of the user-defined type, must be different from built-in type names
	 * @param ti		{@link TysonInstance} representing TYSON array value of the user-defined array
	 */
	 TysonUserDefinedArray(String name, TysonInstance ti) {
	
		List<String> builtinTypes = Arrays.asList("string", "integer", "decimal", "double", "boolean", "null", "object", "array");
		
		if(!builtinTypes.contains(name)) {
			this.typeName = "(" + name + ")";
			members = ((TysonArray)ti).members;
		} else throw new RuntimeException("Trying to build user defined array with type annotation from built-ins");
		
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isUserDefinedType()</code>
	 * on instances of {@link TysonUserDefinedArray}.
	 */
	public boolean isUserDefinedType() {
		return true;
	}
	
	/**
	 * Gets the <code>String</code> name of this {@link TysonUserDefinedArray} type.
	 */
	public String getTypeName() {
		return this.typeName;
	}

	@Override
	public String toString() {
		String tArrBody = super.toString();
		return tArrBody; 
	}

}
