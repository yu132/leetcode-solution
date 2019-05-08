package other.middle.arrayAndString;

public class _6 {

	class Solution {
	    public boolean increasingTriplet(int[] nums) {
	        int m1=Integer.MAX_VALUE,m2=Integer.MAX_VALUE;
	        
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]<=m1){
	        		m1=nums[i];
	        	}else if(nums[i]<=m2){
	        		m2=nums[i];
	        	}else{
	        		return true;
	        	}
	        }
	    	
	        return false;
	    }
	}
	
}
