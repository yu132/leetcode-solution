package old._0200_0299;

import java.util.HashSet;
import java.util.Set;

public class _202 {

	class Solution {
	    public boolean isHappy(int n) {
	        
	    	Set<Integer> path=new HashSet<>();
	    	
	    	while(n!=1){
	    		
	    		int sum=0;
	    		
	    		while(n!=0){
	    			sum+=Math.pow(n%10, 2);
	    			n/=10;
	    		}
	    		
	    		if(path.contains(sum))
	    			return false;
	    		
	    		path.add(sum);
	    		
	    		n=sum;
	    	}
	    	
	    	return true;
	    }
	}
	
}
