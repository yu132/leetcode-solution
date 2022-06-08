package _0900_0999;

import java.util.HashSet;
import java.util.Set;

public class _983 {

	class Solution {
	    public int mincostTickets(int[] days, int[] costs) {
	    	if(days.length==0)
	    		return 0;
	    	
	        int[] dp=new int[days[days.length-1]+1];
	        
	        Set<Integer> set=new HashSet<>();
	        
	        for(int day:days)
	        	set.add(day);
	        
	        for(int i=1;i<dp.length;i++){
	        	if(!set.contains(i))
	        		dp[i]=dp[i-1];
	        	else{
	        		int cost1=dp[i-1]+costs[0];
	        		int cost7=costs[1]+(i>=7?dp[i-7]:0);
	        		int cost30=costs[2]+(i>=30?dp[i-30]:0);
	        		
	        		dp[i]=Math.min(cost1, cost7);
	        		dp[i]=Math.min(cost30, dp[i]);
	        	}
	        }
	        
	        return dp[dp.length-1];
	    }
	}
	
}
