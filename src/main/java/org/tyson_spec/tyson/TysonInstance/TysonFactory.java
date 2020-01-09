package org.tyson_spec.tyson.TysonInstance;

import java.math.BigDecimal;

/**
 * Implements the Singleton and Factory principle on the 
 * construction of {@link TysonInstance}s.
 * Only one <code>TysonFactory</code> will be created on the first access,
 * all further accesses will be done on this instance.
 * <code>TysonFactory</code> provides the functionality to instantiate
 * new <code>TYSON</code> class instances.
 * 
 * @author Diana Steffen
 *
 */

public class TysonFactory {
	
	/**
	 * Private variable that will be used to only 
	 * instantiate the <code>TysonFactory</code> once according to
	 * the Singleton design principle.
	 */
	private static TysonFactory singleton;
	
	/**
	 * Empty constructor that prevents manual instantiation of the factory 
	 * not following the singleton principle.
	 */
	private TysonFactory() {};
	
	/**
	 * Creates a new <code>TysonFactory</code> on the first call, and returns the 
	 * existing one on every future call. 
	 * 
	 * @return		Singleton <code>TysonFactory</code> instance.
	 */
	public static TysonFactory getInstance() {
		
		if (singleton == null) {
			singleton = new TysonFactory(); 
		}
		return singleton;
	}
	
	/**
	 * Creates a new empty {@link TysonArray}.
	 * 
	 * @return		empty <code>TysonArray</code>
	 */
	public TysonArray createArray() {
		TysonArray a = new TysonArray();
		return a;
	}
	
	/**
	 * Creates a new {@link TysonBoolean} corresponding to the specified value.
	 * 
	 * @param value		<code>boolean</code> value <code>TysonBoolean</code> to be created
	 * @return			<code>TysonBoolean</code>
	 */
	public TysonBoolean createBoolean(boolean value) {
		TysonBoolean b = new TysonBoolean(value);
		return b;
	}
	
	/**
	 * Creates a new {@link TysonDecimal} corresponding to the specified decimal value.
	 * 
	 * @param value		{@link java.math.BigDecimal} value of the <code>TysonDecimal</code> to be created
	 * @return			<code>TysonDecimal</code>
	 */
	public TysonDecimal createDecimal(BigDecimal value) {
		TysonDecimal d = new TysonDecimal(value);
		return d;
	}
	
	/**
	 * Creates a new {@link TysonDouble} corresponding to the specified double value.
	 * 
	 * @param value		<code>double</code> value of the <code>TysonDouble</code> to be created
	 * @return			<code>TysonDouble</code>
	 */
	public TysonDouble createDouble(double value) {
		TysonDouble d = new TysonDouble(value);
		return d;
	}
	
	/**
	 * Creates a new {@link TysonInteger} corresponding to the specified <code>int value</code>.
	 * 
	 * @param value		<code>int</code> value of the <code>TysonInteger</code> to be created
	 * @return			<code>TysonInteger</code>
	 */
	public TysonInteger createInteger(int value) {
		TysonInteger i = new TysonInteger(value);
		return i;
	}
	
	
	/**
	 * Creates a new {@link TysonNull} instance with value <code>null</code>.
	 * 
	 * @return			<code>TysonNull</code>
	 */
	public TysonNull createNull() {
		TysonNull n = new TysonNull();
		return n;
	}
	
	/**
	 * Creates a new empty {@link TysonObject}.
	 * 
	 * @return			empty <code>TysonObject</code>
	 */
	public TysonObject createObject() {
		TysonObject o = new TysonObject();
		return o;
	}
	
	/**
	 * Creates a new {@link TysonString} corresponding to the specified <code>String value</code>.
	 * 
	 * @param value		<code>String</code> value of <code>TysonString</code> to be created
	 * @return			<code>TysonString</code>
	 */
	public TysonString createString(String value) {
		TysonString s = new TysonString(value);
		return s;
	}
	
	/**
	 * Creates a new {@link TysonUserDefinedAtomic} instance of the user defined type <code>"name"</code> 
	 * with the provided <code>TysonInstance</code> value.
	 * 
	 * @param name		<code>String</code> name of the user-defined type
	 * @param ti		<code>TYSON</code> value of the user-defined type
	 * @return			<code>TysonUserDefinedAtomic</code> instantiated with the type name and the given value
	 */
	public TysonUserDefinedAtomic createUserDefinedAtomic(String name, TysonInstance ti) {
		TysonUserDefinedAtomic u = new TysonUserDefinedAtomic(name, ti);
		return u;
	}
	
	/**
	 * Creates a new {@link TysonUserDefinedArray} instance of the user defined type <code>"name"</code>
	 * with the provided <code>TysonInstance</code> value. The provided value needs to be a {@link TysonArray}.
	 * 
	 * @param name		<code>String</code> name of the user-defined type
	 * @param ti		<code>TYSON</code> array value of the user-defined type
	 * @return			<code>TysonUserDefinedArray</code> instantiated with the type name and the given array value
	 */
	public TysonUserDefinedArray createUserDefinedArray(String name, TysonInstance ti) {
		TysonUserDefinedArray u = new TysonUserDefinedArray(name, ti);
		return u;
	}
	
	/**
	 * Creates a new {@link TysonUserDefinedObject} instance of the user defined type <code>"name"</code>
	 * with the provided <code>TysonInstance</code> value. The provided value needs to be a {@link TysonObject}.
	 * 
	 * @param name		<code>String</code> name of the user-defined type
	 * @param ti		<code>TYSON</code> object value of the user-defined type
	 * @return			<code>TysonUserDefinedObject</code> instantiated with the type name and the given object value
	 */
	public TysonUserDefinedObject createUserDefinedObject(String name, TysonInstance ti) {
		TysonUserDefinedObject u = new TysonUserDefinedObject(name, ti);
		return u;
	}
	
	
}
