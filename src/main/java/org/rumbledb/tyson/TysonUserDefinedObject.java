package org.rumbledb.tyson;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the <code>TYSON</code> user-defined object value.
 * Extends the {@link TysonObject} class.
 * 
 * @author 		Diana Steffen
 */

public class TysonUserDefinedObject extends TysonObject{
	
	/**
	 * Holds the user-defined name for this TYSON object
	 * which must be different from all built-in type names.
	 * The type name must correspond to a <code>JSON String</code>.
	 */
	String typeName;
	
	/**
	 * Constructs an instance of the {@link TysonUserDefinedObject} class.
	 * Checks if the provided type name is one of the built-in type names
	 * and throws a RuntimeException if this is the case, as user-defined type
	 * names must be different from built-in type names.
	 * Sets the type name according to the provided name and the 
	 * value according to the provided TysonInstance.
	 * 
	 * @param name		<code>String</code> name of the user-defined type, must be different from built-in type names
	 * @param ti		{@link TysonInstance} representing TYSON object value of the user-defined object
	 */
	 TysonUserDefinedObject(String name, TysonInstance ti) {
	
		List<String> builtinTypes = Arrays.asList("string", "integer", "decimal", "double", "boolean", "null", "object", "array");
		
		if(!builtinTypes.contains(name)) {
			char first = name.charAt(0);
			char last = name.charAt(name.length() - 1);
						
			if(!(first=='"' && last=='"')) {
				name = '"' + name + '"';
				System.out.println("newName: " +name);

			}
			
			this.typeName = "(" + name + ")";
			members = ((TysonObject)ti).members;
			orderList = ((TysonObject)ti).orderList;
		} else throw new RuntimeException("Trying to build user defined object with type annotation from built-ins");
		
	}
	
    /**
     * Returns <code>boolean</code> answer <code>true</code> for <code>isUserDefinedType()</code> on
     * instances of {@link TysonUserDefinedObject}.
     */
	public boolean isUserDefinedType() {
		return true;
	}
	
	/**
	 * Gets the <code>String</code> name of this {@link TysonUserDefinedObject} type.
	 */
	public String getTypeName() {
		return this.typeName;
	}
	
	@Override
	public String toString() {
		String tObjBody = super.toString();
		return tObjBody;  
	}
}
