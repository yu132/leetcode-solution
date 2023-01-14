package old._0400_0499;

public class _414 {

	class Solution {
	    public int thirdMax(int[] nums) {
	    	
	    	int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
	    	
	    	boolean f=true;
	    	int flag=0;
	    	
	    	for(int i=0;i<nums.length;i++){
	    		
	    		if(nums[i]==Integer.MIN_VALUE&&f){
	    			f=false;
	    			++flag;
	    		}
	    		
	    		if(nums[i]>max1){
	    			++flag;
	    			max3=max2;
	    			max2=max1;
	    			max1=nums[i];
	    		}else if(nums[i]>max2){
	    			if(nums[i]!=max1){
	    				++flag;
	    				max3=max2;
	    				max2=nums[i];
	    			}
	    		}else if(nums[i]>max3){
	    			if(nums[i]!=max2){
	    				++flag;
	    				max3=nums[i];
	    			}
	    		}
	    	}
	    	
	    	return flag<3?max1:max3;
	    }
	}
	
}
