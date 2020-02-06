package org.rumbledb.tyson;


import java.math.BigDecimal;

/**
 * Represents the <code>TYSON</code> decimal value.
 * 
 * @author 		Diana Steffen
 */
public class TysonDecimal extends TysonInstance  {
	
	/**
	 * Represents the semantical value as a {@link java.math.BigDecimal}.
	 * The value space is the set of all decimal numbers.
	 * These are all real numbers with a finite decimal representation.
	 */
	BigDecimal value;
	
	
	/**
	 * Constructs an instance of the {@link TysonDecimal} class.
	 * Sets value and syntactical value according to the provided {@link BigDecimal}.
	 * 
	 * @param decimalValue		<code>BigDecimal</code> specifying value of <code>TysonDecimal</code>
	 */
	 TysonDecimal(BigDecimal decimalValue) {
		this.value = decimalValue;
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isDecimal()</code> on
	 * instances of {@link TysonDecimal}.
	 */
	public boolean isDecimal() {
		return true;
	}

	/**
	 * Gets the value of this {@link TysonDecimal} as a {@link BigDecimal}.
	 */
	public BigDecimal getDecimalValue() {
		return this.value;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonDecimal} value.
	 */
	public String getLexicalValue() {
		return this.value.toEngineeringString();
	}
	
	/**
	 * Gets the String name of the {@link TysonDecimal} type.
	 */
	public String getTypeName() {
		return "(\"decimal\")";
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonDecimal}.
	 */
	public boolean isAtomic() {
		return true;
	}
	
	@Override
	public String toString() {
		return this.getTypeName() + " " + this.getLexicalValue();
	}
	

}
