package _0600_0699;

public class _645 {
	
	class Solution {
		
		public Integer more=null;
		
		public Integer less=null;
		
		public void fill(int[] nums,int i) {
			if(nums[i-1]==i) {
				more=i;
			}else if(nums[i-1]==-1) {
				nums[i-1]=i;
			}else {
				int temp=nums[i-1];
				nums[i-1]=i;
				fill(nums,temp);
			}
		}
		
	    public int[] findErrorNums(int[] nums) {
	        for(int i=0;i<nums.length;++i) {
	        	if(nums[i]==i+1) {
	        		continue;
	        	}
	        	int temp=nums[i];
	        	nums[i]=-1;
	        	fill(nums,temp);
	        }
	    	for(int i=0;i<nums.length;++i) {
	    		if(nums[i]==-1) {
	    			less=i+1;
	    		}
	    	}
	    	return new int[] {more,less};
	    }
	}
	
}
