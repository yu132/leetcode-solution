package old._0100_0199;

public class _169 {

	class Solution {
	    public int majorityElement(int[] nums) {
	    	
	    	int mj=nums[0];
	    	int count=1;
	    	
	        for(int i=1;i<nums.length;i++){
	        	if(nums[i]==mj)
	        		++count;
	        	else{
	        		--count;
	        		if(count==0){
	        			mj=nums[i];
	        			count=1;
	        		}
	        	}
	        }
	        
	        return mj;
	    }
	}
	
}
