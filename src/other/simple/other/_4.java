package other.simple.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4 {

	class Solution {
	    public List<List<Integer>> generate(int numRows) {
	    	
	    	List<List<Integer>> ans=new ArrayList<>();
	    	
	    	if(numRows==0)
	    		return ans;
	    	
	    	ans.add(new ArrayList<>(Arrays.asList(1)));
	    	
	    	if(numRows==1)
	    		return ans;
	    	
	    	ans.add(new ArrayList<>(Arrays.asList(1,1)));
	    	
	    	for(int i=3;i<=numRows;i++){
	    		ans.add(new ArrayList<>());
	    		
	    		ans.get(i-1).add(1);
	    		
	    		for(int j=1;j<i-1;j++){
	    			int now=ans.get(i-2).get(j-1)+ans.get(i-2).get(j);
	    			
	    			ans.get(i-1).add(now);
	    		}
	    		
	    		ans.get(i-1).add(1);
	    	}
	    	
	    	return ans;
	    }
	}
	
}
