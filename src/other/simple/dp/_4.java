package other.simple.dp;

public class _4 {
	
	class Solution {
		int[][] dp;
		
	    public int rob(int[] nums) {
	    	if(nums.length==0)
	    		return 0;
	    	if(nums.length==1)
	    		return nums[0];
	    	
	    	dp=new int[nums.length][nums.length];
	    	
	    	for(int i=0;i<dp.length;i++){
	    		for(int j=0;j<dp[0].length;j++){
	    			dp[i][j]=-1;
	    		}
	    	}
	    	
	    	return rob(nums,0,nums.length-1);
	    }
	    
	    public int rob(int[] nums,int f,int b) {
	    	if(f>b)
	    		return 0;
	    	
	    	if(dp[f][b]==-1){
	    		
		    	int max=0;
		    	
		    	for(int i=f;i<=b;i++){
		    		int chooseThis=nums[i]+rob(nums,f,i-2)+rob(nums,i+2,b);
		    		if(chooseThis>max)
		    			max=chooseThis;
		    	}
	    	
		    	dp[f][b]=max;
	    	}
	    	
	    	return dp[f][b];
	    }
	}
	
}
