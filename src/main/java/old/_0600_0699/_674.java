package old._0600_0699;

public class _674 {

	class Solution {
	    public int findLengthOfLCIS(int[] nums) {
	        if(nums.length==0)
	        	return 0;
	        
	        int length=1;
	        
	        int cur=1;
	        
	        for(int i=1;i<nums.length;i++){
	        	if(nums[i]>nums[i-1])
	        		++cur;
	        	else{
	        		length=Math.max(length, cur);
	        		cur=1;
	        	}
	        }
	        
	        return Math.max(length, cur);
	    }
	}
	
}
