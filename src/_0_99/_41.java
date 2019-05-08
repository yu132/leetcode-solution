package _0_99;

public class _41 {

	/**
	 * 
	 * 就是说每个正数应该放在nums中它自己减一的位置上，如果这个位置上不是这个数，就返回这个数
	 * 
	 * 知道这个原理剩下就是移动位置的问题了，如果不在1-nums.length这个范围的数无需移动
	 * 
	 * @author 87663
	 *
	 */
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	        for(int i=0;i<nums.length;i++){
	        	int num=nums[i];
	        	
	        	while(num>0&&num<=nums.length){
	        		if(nums[num-1]==num)
	        			break;
	        		int temp=nums[num-1];
	        		nums[num-1]=num;
	        		num=temp;
	        	}
	        }
	        
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]!=i+1)
	        		return i+1;
	        }
	        
	        return nums.length+1;
	    }
	}
	
}
