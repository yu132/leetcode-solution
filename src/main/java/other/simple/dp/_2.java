package other.simple.dp;

public class _2 {

	class Solution {
	    public int maxProfit(int[] prices) {
	        
	    	int max=0;
	    	int sum=0;
	    	
	    	for(int i=1;i<prices.length;i++){
	    		int nowPrice=prices[i]-prices[i-1];
	    		sum=Math.max(0, sum+nowPrice);
	    		max=Math.max(max, sum);
	    	}
	    	
	    	return max;
	    }
	}
	
}
