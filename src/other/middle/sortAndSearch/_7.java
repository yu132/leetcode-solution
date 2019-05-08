package other.middle.sortAndSearch;

import java.util.Arrays;

public class _7 {
	
	public static void main(String[] args) {
		System.out.println(new _7().new Solution().search(new int[]{4,5,6,7,8,123,567,22222,333333,0,1,2}, 1));
	}

	class Solution {
	    public int search(int[] nums, int target) {
	    	if(nums.length==0)
	    		return -1;
	    	
	        int loc=find(nums,0,nums.length-1);
	        
	        if(loc==-1){
	        	int a=Arrays.binarySearch(nums, target);
	        	
	        	if(a<0)
	        		return -1;
	        	else		
	        		return a;
	        }else{
	        	int a1=Arrays.binarySearch(nums, 0, loc, target);
	        	int a2=Arrays.binarySearch(nums, loc, nums.length, target);
	        	
	        	if(a1<0&&a2<0)
	        		return -1;
	        	
	        	if(a1>=0)
	        		return a1;
	        	if(a2>=0)
	        		return a2;
	        	
	        	return -1;
	        }
	    }
	    
	    public int find(int[] nums,int l,int r) {

	        if(l==r||nums[l]<nums[r])
	        	return -1;
	    	
	    	if(nums[l]>nums[l+1])
	    		return l+1;
	        
	        int mid=(l+r)>>>1;
	        
	        return find(nums,l,mid)+find(nums,mid,r)+1;
	    }
	}
	
}
