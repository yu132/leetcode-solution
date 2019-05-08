package other.middle.sortAndSearch;

import java.util.Arrays;

public class _3 {

	class Solution {
		public int findKthLargest(int[] nums, int k) {

	        Arrays.sort(nums);
	        
	        return nums[nums.length-k];
	    }
		
	    /*public int findKthLargest(int[] nums, int k) {
	        
	    	partition(nums,nums.length-k,0,nums.length-1);
	    	
	    	return nums[nums.length-k];
	    }
	    
	    public boolean partition(int[] nums,int k,int f,int b){
	    	
	    	if(f>=b)
	    		return false;
	    	
	    	int p=nums[f];
	    	
	    	int fIndex=f+1;
	    	int bIndex=b;
	    	
	    	while(fIndex<bIndex){
	    		if(nums[fIndex]<=p)
	    			++fIndex;
	    		else if(nums[bIndex]>p)
	    			--bIndex;
	    		else if(nums[fIndex]>p&&nums[bIndex]<=p){
	    			int temp=nums[fIndex];
	    			nums[fIndex]=nums[bIndex];
	    			nums[bIndex]=temp;
	    			
	    			++fIndex;
	    			--bIndex;
	    		}
	    	}
	    	
	    	int mid;
	    	
	    	if(fIndex>=nums.length||nums[fIndex]>p)
	    		mid=fIndex-1;
	    	else
	    		mid=fIndex;
	    	
    		nums[f]=nums[mid];
    		nums[mid]=p;
    		
    		if(mid==k)
    			return true;
	    	
	    	return partition(nums,k,f,mid-1)||partition(nums,k,mid+1,b);
	    }*/
	}
	
	public static void main(String[] args) {
		System.out.println(new _3().new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
	}
}
