package org.rumbledb.tyson;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the <code>TYSON</code> user-defined atomic value.
 * The atomic user-defined type must have a clearly documented value space.
 * This specification and documentation need to be done by the user.
 * 
 * @author 		Diana Steffen
 */
public class TysonUserDefinedAtomic extends TysonInstance{
	
	/**
	 * Holds the user-defined name for this TYSON value
	 * which must be different from all built-in type names.
	 * The type name must correspond to a <code>JSON String</code>.
	 */
	String typeName;
	
	/**
	 * Represents the syntactical value of this {@link TysonUserDefinedAtomic}.
	 * The lexical space and lexical mapping must be clearly defined,
	 * but its specification and documentation need to be done by the user.
	 */
	String litValue;
	
	
	/**
	 * Constructs an instance of the {@link TysonUserDefinedAtomic} class.
	 * Checks if the provided type name is one of the built-in type names
	 * and throws a <code>RuntimeException</code> if this is the case, as user-defined type
	 * names must be different from built-in type names.
	 * Sets the name and syntactical value according to the provided name and
	 * {@link TysonInstance} value.
	 * 
	 * @param name		<code>String</code> name of the user-defined type, must be different from built-in type names
	 * @param ti		{@link TysonInstance} representing TYSON value of the user-defined type
	 */
	TysonUserDefinedAtomic(String name, TysonInstance ti) {
	
		List<String> builtinTypes = Arrays.asList("string", "integer", "decimal", "double", "boolean", "null", "object", "array");

		if(!builtinTypes.contains(name)) {
			char first = name.charAt(0);
			char last = name.charAt(name.length() - 1);
						
			if((first=='"' && last=='"')) {
				int len = name.length();
				name = (String) name.subSequence(1, len-1);
				//System.out.println("newName: " +name);
			}
			
			this.typeName = name;
			this.litValue = ti.getLexicalValue();
		} else throw new RuntimeException("Trying to build user defined type with type annotation from built-ins");

		
		
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isUserDefinedType()</code>
	 * on instances of {@link TysonUserDefinedAtomic}.
	 */
	public boolean isUserDefinedType() {
		return true;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonUserDefinedAtomic} value.
	 */
	public String getLexicalValue() {
		return this.litValue;
	}
	
	/**
	 * Gets the <code>String</code> name of the {@link TysonUserDefinedAtomic} type.
	 */
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonUserDefinedAtomic}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getTypeName() + " " + "\""+ this.litValue+"\""; 
	}
	
	
}
