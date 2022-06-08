package other.middle.sortAndSearch;

public class _4 {
	
	class Solution {
	    public int findPeakElement(int[] nums) {
	        
	    	if(nums.length==0)
	    		return 0;
	    	
	    	int l=0,r=nums.length-1;
	    	
	    	while(l<=r){
	    		
	    		if(l==r)
	    			return l;
	    		
	    		int mid=(l+r)/2;
	    		
	    		if(nums[mid]<nums[mid+1])
	    			l=mid+1;
	    		else
	    			r=mid;
	    	}
	    	
	    	return -1;
	    }
	}
	
}
