package _0300_0399;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _310 {
/* v1
	class Solution {
		
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    	
	    	Map<Integer,Set<Integer>> logs=new HashMap<>(); 
	    	
	        for(int i=0;i<n;i++)
	        	logs.put(i,new HashSet<>());
	        
	        for(int i=0;i<edges.length;i++){
	        	logs.get(edges[i][0]).add(edges[i][1]);
	        	logs.get(edges[i][1]).add(edges[i][0]);
	        }
	        
	        List<Integer> tempLogs=new ArrayList<>(n/10);
	        
	        List<Integer> tempLogs2=new ArrayList<>(n/10);
	        
	        for(Entry<Integer,Set<Integer>> entry:logs.entrySet()){
	        	if(entry.getValue().size()==1){
	        		tempLogs.add(entry.getKey());
	        	}
	        }
	        
	        while(logs.size()>2){
	        	
	        	System.out.println(logs.size());
	        	
	        	for(int i=0;i<tempLogs.size();i++){
	        		
	        		Set<Integer> pointSet=logs.remove(tempLogs.get(i));
	        		
					for(Integer point:pointSet){
						
						Set<Integer> set=logs.get(point);
						
						set.remove(tempLogs.get(i));
						
						if(set.size()==1){
							tempLogs2.add(point);
						}
				    }
	        	}
	        	
	        	tempLogs.clear();
	        	
	        	tempLogs.addAll(tempLogs2);
	        	
	        	tempLogs2.clear();
	        }
	        
	        List<Integer> ans=new ArrayList<>();
	        
	        ans.addAll(logs.keySet());
	        
	        return ans;
	    }
	}*/
	class Solution {
		
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    	
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] logs=new ArrayList[n];
	    	
			Set<Integer> leave=new HashSet<>();
			
	    	int[] count=new int[n];
	    	
	        for(int i=0;i<n;i++){
	        	leave.add(i);
	        	logs[i]=new ArrayList<>();
	        }
	        
	        for(int i=0;i<edges.length;i++){
	        	logs[edges[i][0]].add(edges[i][1]);
	        	logs[edges[i][1]].add(edges[i][0]);
	        	
	        	++count[edges[i][0]];
	        	++count[edges[i][1]];
	        }
	        
	        List<Integer> tempLogs=new LinkedList<>();
	        
	        List<Integer> tempLogs2=new LinkedList<>();
	        
	        for(int i=0;i<count.length;i++){
	        	if(count[i]==1){
	        		tempLogs.add(i);
	        	}
	        }
	        
	        while(leave.size()>2){
	        	
	        	for(Integer i:tempLogs){
	        		
	        		--count[i];
	        		
	        		leave.remove(i);
	        		
					for(Integer point:logs[i]){
						
						--count[point];
						
						if(count[point]==1){
							tempLogs2.add(point);
						}
				    }
	        	}
	        	
	        	tempLogs.clear();
	        	
	        	tempLogs.addAll(tempLogs2);
	        	
	        	tempLogs2.clear();
	        }
	        
	        List<Integer> ans=new ArrayList<>();
	        
	        ans.addAll(leave);
	        
	        return ans;
	    }
	}
}
