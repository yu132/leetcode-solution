package _0600_0699;

public class _643 {
	
	class Solution {
	    public double findMaxAverage(int[] nums, int k) {
	        
	    	int sum=0;
	    	
	    	for(int i=0;i<k;++i) {
	    		sum+=nums[i];
	    	}
	    	
	    	int max=sum;
	    	
	    	for(int i=k,j=0;i<nums.length;++i,++j) {
	    		sum-=nums[j];
	    		sum+=nums[i];
	    		if(sum>max) {
	    			max=sum;
	    		}
	    	}
	    	
	    	return max*1.0/k;
	    }
	}
	
}
