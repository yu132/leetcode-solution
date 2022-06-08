package other.simple.array;

public class _8 {

	class Solution {
	    public void moveZeroes(int[] nums) {
	    	int f=0;
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]!=0)
	        		nums[f++]=nums[i];
	        }
	        for(int i=f;i<nums.length;i++)
	        	nums[i]=0;
	    }
	}
	
}
