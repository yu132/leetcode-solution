package old._0200_0299;

import java.util.HashMap;
import java.util.Map;

public class _219 {

	class Solution {
	    public boolean containsNearbyDuplicate(int[] nums, int k) {
	        Map<Integer,Integer> map=new HashMap<>();
	        
	        for(int i=0;i<nums.length;i++){
	        	if(map.containsKey(nums[i]))
	        		if(i-map.get(nums[i])<=k)
	        			return true;
	        	map.put(nums[i], i);
	        }
	        
	        return false;
	    }
	}
	
}
