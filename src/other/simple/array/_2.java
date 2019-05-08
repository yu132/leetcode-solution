package other.simple.array;

public class _2 {

	class Solution {
	    public int maxProfit(int[] prices) {
	    	if(prices==null)
	    		return 0;
	    	
	    	if(prices.length==0)
	    		return 0;
	    	
	    	int before=prices[0];
	    	int profit=0;
	    	
	        for(int i=1;i<prices.length;i++){
	        	if(prices[i]>=prices[i-1])
	        		continue;
	        	else{
	        		profit+=prices[i-1]-before;
	        		before=prices[i];
	        	}
	        }
	        
	        if(prices[prices.length-1]>before)
	        	profit+=prices[prices.length-1]-before;
	        
	        return profit;
	    }
	}
	
}
