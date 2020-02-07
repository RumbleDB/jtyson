package org.rumbledb.tyson;

/**
 * Represents the <code>TYSON</code> boolean value.
 * 
 * @author 		Diana Steffen
 */

public class TysonBoolean extends TysonInstance {
	
	/**
	 * Represents the semantical value of this {@link TysonBoolean} instance.
	 */
	boolean value;
	
	/**
	 * Constructs an instance of the {@link TysonBoolean} class
	 * with the specified <code>value</code>.
	 * 
	 * @param value		<code>boolean</code> value to instantiate <code>TysonBoolean</code> with
	 */
	 TysonBoolean(boolean value) {
		this.value = value;
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isBoolean()</code> 
	 * on instances of {@link TysonBoolean}.
	 */
	public boolean isBoolean() {
		return true;
	}
	
	/**
	 * Returns the <code>boolean</code> value of this {@link TysonBoolean}.
	 */
	public boolean getBooleanValue() {
		return this.value;
	}
	
	/**
	 * Returns the syntactical representation of the value
	 * of this {@link TysonBoolean}, which is either <code>"true"</code> or <code>"false"</code>.
	 */
	public String getLexicalValue() {
		return String.valueOf(this.value);
	}
	
	/**
	 * Gets the <code>String</code> name of the {@link TysonBoolean} type.
	 */
	public String getTypeName() {
		return "boolean";
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonBoolean}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return "(\"" + this.getTypeName() + "\")" + " " + this.getLexicalValue();
	}
	
}
