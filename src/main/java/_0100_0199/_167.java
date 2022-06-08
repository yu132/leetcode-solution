package _0100_0199;

import java.util.Arrays;

public class _167 {

	class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        
	    	for(int i=0;i<numbers.length;i++){
	    		int index=Arrays.binarySearch(numbers, target-numbers[i]);
	    		if(index<0)
	    			continue;
	    		else if(index==i){
	    			if(numbers[i-1]==numbers[i]){
	    				return new int[]{i,i+1};
	    			}else if(numbers[i+1]==numbers[i]){
	    				return new int[]{i+1,i+2};
	    			}
	    		}else{
	    			return new int[]{i+1,index+1};
	    		}
	    	}
	    	
	    	return null;
	    }
	}
	
}
