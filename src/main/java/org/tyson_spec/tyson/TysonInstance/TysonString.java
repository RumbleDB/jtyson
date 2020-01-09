package org.tyson_spec.tyson.TysonInstance;

/**
 * Represents the <code>TYSON</code> string value.
 * 
 * @author 		Diana Steffen
 */

public class TysonString extends TysonInstance {
	
	/**
	 * Represents the semantical value as a <code>JAVA String</code>.
	 * The value space is the set of all <code>JSON Strings</code>.
	 */
	String value;
	
	
	/**
	 * Constructs an instance of the {@link TysonString} class.
	 * Sets the value and syntactical value according to the provided <code>value String</code>.
	 * 
	 * @param value		<code>String</code> specifying value of {@link TysonString}
	 */
	 TysonString(String value) {
		this.value = value;
	}
	
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isString()</code> on
	 * instances of {@link TysonString}.
	 */
	public boolean isString() {
		return true;
	}
	
	/**
	 * Gets the value of this {@link TysonString}.
	 */
	public String getStringValue() {
		return this.value;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonString}.
	 */
	public String getLexicalValue() {
		return this.value;
	}
	
	/**
	 * Gets the <code>String</code> name of the {@link TysonString} type.
	 */
	public String getTypeName() {
		return "(\"string\")";
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonString}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getTypeName() + " " + this.getLexicalValue();
	}
}
