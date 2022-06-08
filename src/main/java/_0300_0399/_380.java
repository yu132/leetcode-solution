package _0300_0399;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

public class _380 {

	class RandomizedSet {
		
		private Map<Integer,Integer> valueMap=new HashMap<>();
		
		private Map<Integer,Integer> indexMap=new HashMap<>();
		
		private Random r=new Random();
		
	    /** Initialize your data structure here. */
	    public RandomizedSet() {}
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if(valueMap.containsKey(val))
	    		return false;
	    	
	    	valueMap.put(val, valueMap.size());
    		indexMap.put(indexMap.size(), val);
	    	
	    	return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	    	if(!valueMap.containsKey(val))
	    		return false;
	    	
	    	int index=valueMap.remove(val);
	    	indexMap.remove(index);
	    	
	    	if(index==indexMap.size())
	    		return true;
	    		
    		Integer value=indexMap.remove(indexMap.size());
    		
    		if(value!=null){
	    		indexMap.put(index, value);
	    		valueMap.put(value, index);
    		}
	    	
	    	return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	if(indexMap.size()==0)
	    		throw new NoSuchElementException();
	        return indexMap.get(r.nextInt(indexMap.size()));
	    }
	}
	
}
