package other.middle.sortAndSearch;

public class _1 {

	class Solution {
	    public void sortColors(int[] nums) {
	        int fIndex=0;
	        int bIndex=nums.length-1;
	        
	        int i=0;
	        
	        while(i<=bIndex){
	        	if(nums[i]==0){
	        		int temp=nums[fIndex];
	        		nums[fIndex]=nums[i];
	        		nums[i]=temp;
	        		
	        		++fIndex;
	        		++i;
	        	}else if(nums[i]==2){
	        		int temp=nums[bIndex];
	        		nums[bIndex]=nums[i];
	        		nums[i]=temp;
	        		
	        		--bIndex;
	        	}else
	        		++i;
	        }
	    }
	}
	
}
