package org.tyson_spec.tyson.TysonInstance;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the <code>TYSON</code> object value.
 * 
 * @author 		Diana Steffen
 */
public class TysonObject extends TysonInstance  {
	
	/**
	 * Holds the <code>(key, value)</code> pairs as a {@link java.util.Map}.
	 * The value space is the set of all TYSON objects.
	 */
	Map<String, TysonInstance> members;
	
	/**
	 * Holds the object keys as a {@link java.util.List}.
	 * This preserves the order in which <code>(key, value)</code> pairs were added.
	 */
	List<String> orderList;
	
	/**
	 * Constructs an instance of the {@link TysonObject} class.
	 * <code>(key, value)</code> pairs are stored in a {@link java.util.HashMap}.
	 * The order is preserved in an {@link java.util.ArrayList}.
	 * The initial {@link TysonObject} is empty.
	 */
	TysonObject() {
		members = new HashMap<String, TysonInstance>();
		orderList = new ArrayList<String>();
	}

	/**
	 * Returns <code>boolean</code> answer <code>true</code> for <code>isObject()</code> on
	 * instances of {@link TysonObject}.
	 */
	public boolean isObject() {
		return true;
	}
	
	/**
	 * Returns the number of <code>(key, value)</code> pairs in this {@link TysonObject}.
	 */
	public int objectSize(){
		return members.size();
    }

	/**
	 * Gets a <code>String List</code> of all the keys stored in the object in the
	 * order in which they were added.
	 */
	public List<String> getKeys(){
		return orderList;
    }

	/**
	 * Checks if this {@link TysonObject} includes a pair with the 
	 * given key.
	 */
    public boolean hasKey(String key){
    	return members.containsKey(key);
    }

    /**
     * Gets the item that is associated with the specified key.
	 * Returns <code>null</code> if the key is not found.
     */
    public TysonInstance getItem(String key){
        return members.get(key);
    }


    /**
     * Sets the value associated with the specified key to the <code>newValue</code>.
	 * Throws a runtime exception if the key is not contained in the object.
     */
    public void setItem(String key, TysonInstance newValue){
    	if(!members.containsKey(key)) {
    		throw new RuntimeException("key not contained in object");
    	}
    	members.replace(key, newValue);
    }

    /**
     * Adds a new <code>(key, value)</code> pair to this {@link TysonObject}.
	 * If the object previously contained a value associated with the specified key,
	 * the old value is replaced by the specified <code>value</code>.
     */
    public void addPair(String key, TysonInstance value){
    	members.put(key, value);
    	orderList.add(key);
    }
    
    /**
	 * Gets the <code>String</code> name of this {@link TysonObject} type.
	 */
    public String getTypeName() {
		return "(\"object\")";
	}
    
	 @Override
	 public String toString() {
	    	
	    	int size = this.objectSize();
	    	String[] litObj = new String[size];
	    	List<String> keyList = this.getKeys();
	    	
	    	for (int i = 0; i< size; i++) {
				String key = keyList.get(i);
				TysonInstance value = this.getItem(key);
				litObj[i] = key + " : " + value.toString();
			}
			String res = String.join(", ", litObj);
			res = this.getTypeName() + " { " + res + " } ";
			return res;
	    }
 

}
