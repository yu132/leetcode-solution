package _0300_0399;

import java.util.Arrays;

public class _300 {

	class Solution {
	    public int lengthOfLIS(int[] nums) {
	        int[] temp=new int[nums.length];
	        
	        int len=0;
	        
	        for(int i=0;i<nums.length;i++){
	        	int loc=Arrays.binarySearch(temp,0,len+1,nums[i]);
	        			
	        	if(loc<0){
	        		int ins=-loc-1;
	        		temp[ins]=nums[i];
	        		if(ins>len)
	        			len=ins;
	        	}
	        }
	        
	        return len;
	    }
	}
	
}
