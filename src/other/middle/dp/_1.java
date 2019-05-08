package other.middle.dp;

public class _1 {

//	class Solution {
//		
//		int[] dp;
//		
//	    public boolean canJump(int[] nums) {
//	    	dp=new int[nums.length];
//	    	
//	    	return canJump(nums,0);
//	    }
//	    
//	    public boolean canJump(int[] nums,int f){
//	    	if(dp[f]==0){
//	    		if(f+nums[f]+1>=nums.length){
//	    			dp[f]=1;
//	    			return true;
//	    		}
//	    		
//	    		for(int i=nums[f];i>=1;i--){
//	    			if(canJump(nums,f+i)){
//	    				dp[f]=1;
//		    			return true;
//	    			}
//	    		}
//	    		dp[f]=-1;
//	    		return false;
//	    	}else{
//		    	if(dp[f]==1)
//		    		return true;
//		    	else
//		    		return false;
//	    	}
//	    }
//	}
	
	//copy的
	public boolean canJump(int[] nums) {
        
        if(nums.length == 0 || nums == null){
            return false;
        }
        int reach = 0 ;
        
        for(int i = 0 ;i<nums.length;i++){
            if(i>reach)//若这个地方到达不了，接下来的地方都不能到达
                return false;
            
            if(i+nums[i]>reach){//记录可以到达的最大的地方
                reach = i +nums[i];
            }
            
        }
        return true;
    }
	
}
