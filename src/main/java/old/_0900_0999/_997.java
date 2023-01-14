package old._0900_0999;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _997 {

	class Solution {
	    public int findJudge(int N, int[][] trust) {
	    	if(N==1)
	    		return 1;
	    	
	        Set<Integer> tf=new HashSet<>();
	        
	        Map<Integer,Integer> tt=new HashMap<>();
	        
	        List<Integer> wait=new ArrayList<>();
	        
	        for(int i=0;i<trust.length;i++){
	        	tf.add(trust[i][0]);
	        	
	        	if(!tf.contains(trust[i][1])){
	        		int count=tt.getOrDefault(trust[i][1], 0);
	        		if(count==N-2)
	        			wait.add(trust[i][1]);
	        		tt.put(trust[i][1], count+1);
	        	}
	        }
	        
	        for(int i=0;i<wait.size();i++)
	        	if(!tf.contains(wait.get(i)))
	        		return wait.get(i);
	        
	        return -1;
	    }
	}
	
}
