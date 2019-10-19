package _0400_0499;

import java.util.ArrayList;
import java.util.List;

public class _401 {

	class Solution {
		
		int[][] t=new int[][]{{8,0},{4,0},{2,0},{1,0},{0,32},{0,16},{0,8},{0,4},{0,2},{0,1}};
		
		public List<String> ans=new ArrayList<>();
		
		public int[] now=new int[2];
		
	    public List<String> readBinaryWatch(int num) {
	    	if(num==0){
	    		ans.add("0:00");
	    		return ans;
	    	}
	    	dfs(0,num);
	    	return ans;
	    }
	    
	    public void dfs(int index,int LED){
	    	if(index==t.length)
	    		return;
	    	
	    	now[0]+=t[index][0];
	    	now[1]+=t[index][1];
	    	
	    	if(now[0]<12&&now[1]<60){
		    	if(LED-1==0){
    				ans.add(now[0]+(now[1]<10?":0":":")+now[1]);
		    	}else{
		    		dfs(index+1,LED-1);
		    	}
	    	}
	    	
	    	now[0]-=t[index][0];
	    	now[1]-=t[index][1];
	    	
	    	dfs(index+1,LED);
	    }
	}
	
}
