package _0_99;

import java.util.HashMap;
import java.util.Map;

public class _01 {
/* v1
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        int[] ans=new int[2];
	        for(int i=0;i<nums.length;i++){
	            for(int j=i+1;j<nums.length;j++){
	                if(nums[i]+nums[j]==target){
	                    ans[0]=i;
	                    ans[1]=j;
	                    return ans;
	                }
	            }
	        }
	        return ans;
	    }
	}*/
	
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer,Integer> loc=new HashMap<>();
	        
	        for(int i=0;i<nums.length;i++){
	        	
	        	Integer aimLoc=loc.get(target-nums[i]);
	        	
	        	if(aimLoc!=null)
	        		return new int[]{aimLoc,i};
	        	else
	        		loc.put(nums[i], i);
	        }
	        
	        throw new IllegalArgumentException();
	    }
	}
	
}
