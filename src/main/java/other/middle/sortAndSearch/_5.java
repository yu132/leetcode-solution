package other.middle.sortAndSearch;

import java.util.Arrays;

public class _5 {

	class Solution {
	    public int[] searchRange(int[] nums, int target) {
	        int l=0,r=nums.length-1;
	        while(l<=r){
	        	int mid=(l+r)>>>1;
	        	
	        	if(nums[mid]>target)
	        		r=mid-1;
	        	else if(nums[mid]<target)
	        		l=mid+1;
	        	else{
	        		return new int[]{searchF(nums,target,l,mid),searchB(nums,target,mid,r)};
	        	}
	        }
	        
	        return new int[]{-1,-1};
	    }
	    
	    public int searchF(int[] nums, int target, int l ,int r){
	    	while(l<r){
	        	int mid=(l+r)>>>1;
	        	
	        	if(nums[mid]>target)
	        		r=mid-1;
	        	else if(nums[mid]<target)
	        		l=mid+1;
	        	else
	        		r=mid;
	        }
	    	return r;
	    }
	    
	    public int searchB(int[] nums, int target, int l ,int r){
	    	while(l<r){
	        	int mid=(l+r)>>>1;
	        	
	        	if(l==mid)
	        		mid+=1;
	        	
	        	if(nums[mid]>target)
	        		r=mid-1;
	        	else if(nums[mid]<target)
	        		l=mid+1;
	        	else
	        		l=mid;
	        }
	    	return l;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new _5().new Solution().searchRange(new int[]{5,7,7,8,8,10}, 8)));
		
	}
}
