package org.rumbledb.tyson;

/**
 * Represents the <code>TYSON</code> double value.
 * 
 * @author 		Diana Steffen
 */
public class TysonDouble extends TysonInstance  {
	
	/**
	 * Represents the semantical value as a <code>JAVA double</code>.
	 * The value space is the set of all decimal numbers that can be expressed
	 * as a double according to IEEE 754.
	 */
	double value;
	
	
	/**
	 * Constructs an instance of the {@link TysonDouble}class.
	 * Sets value and syntactical value according to the provided <code>double</code>.
	 * 
	 * @param value		<code>double</code> value specifying value of <code>TysonDouble</code>
	 */
	 TysonDouble(double value) {
		this.value = value;
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isDouble()</code> on
	 * instances of {@link TysonDouble}.
	 */
	public boolean isDouble() {
		return true;
	}
	
	/**
	 * Gets the value of this {@link TysonDouble} as a <code>JAVA double</code>.
	 */
	public double getDoubleValue() {
		return this.value;
	}
	
	/**
	 * Gets the syntactical representation of this {@link TysonDouble} value.
	 */
	public String getLexicalValue() {
		String doubleAsString = Double.toString(this.value);
		 	if(doubleAsString == "Infinity") {
						
				doubleAsString = "+INF";
						
			} else if (doubleAsString == "-Infinity") {
						
				doubleAsString = "-INF";
						
			}
		 	return doubleAsString;
	}
	
	/**
	 * Gets the String name of the {@link TysonDouble} type.
	 */
	public String getTypeName() {
		return "double";
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for the atomic type {@link TysonDouble}.
	 */
	public boolean isAtomic() {
		return true;
	}

	@Override
	public String toString() {
		String doubleAsStr = this.getLexicalValue();

		if(doubleAsStr == "NaN") {
			
			doubleAsStr = "\"" + doubleAsStr + "\"";
			
		} else if(doubleAsStr == "+INF") {
			
			doubleAsStr = "\"+INF\"";
			
		} else if (doubleAsStr == "-INF") {
			
			doubleAsStr = "\"-INF\"";
			
		}
		
		return "(\"" + this.getTypeName() + "\")" + " " + doubleAsStr;
	}

}

