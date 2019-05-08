package other.simple.other;

public class _6 {

	class Solution {
	    public int missingNumber(int[] nums) {
	        
	    	int num=0;
	    	
	    	for(int i=0;i<=nums.length;i++)
	    		num^=i;
	    	
	    	for(int i=0;i<nums.length;i++)
	    		num^=nums[i];
	    	
	    	return num;
	    }
	}
	
}
