package org.tyson_spec.tyson.TysonInstance;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the <code>TYSON</code> array value.
 * 
 * @author 		Diana Steffen
 */
public class TysonArray extends TysonInstance  {
	
	/**
	 * Holds the array values as a {@link java.util.List}.
	 * The value space is the set of all arrays.
	 */
	List<TysonInstance> members;
	
	
	/**
	 * Constructs an instance of the {@link TysonArray} class as a {@link java.util.ArrayList}.
	 * The initial <code>TysonArray</code> is empty.
	 */
	TysonArray() {
		members = new ArrayList<TysonInstance>();
	}
	
	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isArray()</code> on
	 * instances of {@link TysonArray}.
	 */
	public boolean isArray() {
		return true;
	}
	
	/**
	 * Returns the number of elements stored in this {@link TysonArray}.
	 */
	public int arraySize() {
		return members.size();
	}
	
	/**
	 * Appends a new <code>element</code> at the end of this {@link TysonArray}.
	 * The new <code>element</code> needs to be a {@link TysonInstance}.
	 */
	public void appendElement(TysonInstance element){
		members.add(element);
    }
	
	/**
	 * Gets the element located at the specified <code>index</code>, where 
	 * {@link TysonArray} indexing starts at 0.
	 * Throws an <code>IndexOutOfBoundsException</code> if the <code>index</code> is out of range.
	 */
	public TysonInstance getItem(int index){
		return members.get(index);
    }
	
	/**
	 * Sets the element located at the specified <code>index</code> of this {@link TysonArray} to 
	 * the <code>newValue</code> provided.
	 * The <code>newValue</code> needs to be a {@link TysonInstance}.
	 * Throws an <code>IndexOutOfBoundsException</code> if the <code>index</code> is out of range.
	 */
	public void setItem(int index, TysonInstance newValue){
		members.set(index, newValue);
    }
	
	/**
	 * Gets the <code>String</code> name of this {@link TysonArray} type.
	 */
	public String getTypeName() {
		return "(\"array\")";
	}
	
	
	@Override
	public String toString() {
		int length = this.arraySize();
		String[] litArr = new String[length];
		
		for (int i = 0; i< length; i++) {
			String sub = this.getItem(i).toString();
			litArr[i] = sub;
		}
		String res = String.join(", ", litArr);
		res = this.getTypeName() + " [ " + res + " ]";
		return res;
	}

}
