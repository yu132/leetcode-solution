package _0300_0399;

public class _303 {

	class NumArray {
		
		private int[] sum;

	    public NumArray(int[] nums) {
	    	
	    	if(nums.length==0)
	    		return;
	    	
	        sum=new int[nums.length];
	        
	        sum[0]=nums[0];
	        
	        for(int i=1;i<nums.length;i++){
	        	sum[i]=sum[i-1]+nums[i];
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	    	return sum[j]-(i==0?0:sum[i-1]);
	    }
	}
	
}
