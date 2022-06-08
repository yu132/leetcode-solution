package other.simple.array;

import java.util.HashSet;
import java.util.Set;

public class _4 {

	class Solution {
	    public boolean containsDuplicate(int[] nums) {
	        Set<Integer> s=new HashSet<>();
	        
	        for(int i=0;i<nums.length;i++){
	        	int l=s.size();
	        	s.add(nums[i]);
	        	if(l==s.size())
	        		return true;
	        }
	    	
	    	return false;
	    }
	}
	
}
