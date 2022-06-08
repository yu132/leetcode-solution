package other.simple.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1 {

	class Solution {

		int[] nums;
		List<Integer> copy=new ArrayList<>();
		
	    public Solution(int[] nums) {
	        this.nums=nums;
	        
	        for(int i=0;i<nums.length;i++){
	        	copy.add(nums[i]);
	        }
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	
	    	Collections.shuffle(copy);
	    	
	    	int[] res=new int[nums.length];
	    	
	    	for(int i=0;i<res.length;i++){
	    		res[i]=copy.get(i);
	    	}
	    	
	        return res;
	    }
	}
	
}
