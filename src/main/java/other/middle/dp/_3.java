package other.middle.dp;

import java.util.Arrays;

public class _3 {

	class Solution {
	    public int coinChange(int[] coins, int amount) {
	        Arrays.sort(coins);
	        
	        int[] dp=new int[amount+1];
	        
	        for(int i=0;i<dp.length;i++)
	        	dp[i]=amount+1;
	        
	        dp[0]=0;
	        
	        if(coins.length==0||amount==0)
	        	return 0;
	        
	        for(int i=1;i<=amount;i++){
	        	for(int j=0;j<coins.length&&coins[j]<=i;j++){
	                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
	            }
	        }
	        
	        if(dp[amount]==amount+1) 
	        	return -1;
	        else 
	        	return dp[amount];
	    }
	}
	
}
