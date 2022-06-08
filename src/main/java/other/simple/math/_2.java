package other.simple.math;

public class _2 {

	class Solution {
	    public int countPrimes(int n) {
	        
	    	int count=0;
	    	l:
	    	for(int i=2;i<n;i++){
	    		
	    		int sqrt=(int)Math.sqrt(i);
	    		
	    		for(int j=2;j<=sqrt;j++){
	    			if(i%j==0){
	    				continue l;
	    			}
	    		}
	    		
	    		System.out.println(i);
	    		
	    		count++;
	    	}
	    	
	    	return count;
	    }
	}
	
}
