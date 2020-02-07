package org.rumbledb.tyson;

/**
 * Represents the <code>TYSON</code> null value.
 * 
 * @author 		Diana Steffen
 */


public class TysonNull extends TysonInstance  {
	
	
	/**
	 * Constructs an instance of the {@link TysonNull} class. 
	 * The value will always be set to <code>"null"</code>.
	 */
	 TysonNull() {

	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isNull()</code> on
	 * instances of {@link TysonNull}.
	 */
	public boolean isNull() {
		return true;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonNull} value.
	 */
	public String getLexicalValue() {
		return "null";
	}
	
	/**
	 * Gets the String name of the {@link TysonNull} type.
	 */
	public String getTypeName() {
		return "null";
	}

	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonNull}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return "(\"null\") null";
	}
}
