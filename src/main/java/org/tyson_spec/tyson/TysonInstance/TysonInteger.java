package org.tyson_spec.tyson.TysonInstance;

/**
 * Represents the <code>TYSON</code> integer value.
 * 
 * @author 		Diana Steffen
 */

public class TysonInteger extends TysonInstance  {
	
	/**
	 * Represents the semantical value as a <code>JAVA int</code> value.
	 * The value space of the {@link TysonInteger} is the set of all integers.
	 */
	int value;
	
	/**
	 * Constructs an instance of the {@link TysonInteger} class.
	 * Sets value and syntactical value according to the provided <code>int value</code>.
	 * 
	 * @param value		<code>int value</code> specifying value of {@link TysonInteger}
	 */
	 TysonInteger(int value) {
		this.value = value;
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isInteger()</code> on
	 * instances of {@link TysonInteger}.
	 */
	public boolean isInteger() {
		return true;
	}
	
	/**
	 * Gets the value of this {@link TysonInteger} as a <code>JAVA int</code>.
	 */
	public int getIntegerValue() {
		return this.value;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonInteger} value.
	 */
	public String getLexicalValue() {
		return Integer.toString(this.value);
	}
	
	/**
	 * Gets the <code>String</code> name of the {@link TysonInteger} type.
	 */
	public String getTypeName() {
		return "(\"integer\")";
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonInteger}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getTypeName() + " " + Integer.toString(this.value);
	}

}
