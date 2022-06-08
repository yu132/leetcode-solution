package _0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _131 {

	class Solution {
		
	    public List<List<String>> partition(String s) {
	    	Map<Integer,List<Integer>> pair=getPalindrome(s);
	    	
	    	List<List<String>> ans=new ArrayList<>();
	    	
	    	dfs(pair, s, new ArrayList<>(), ans, 0);
	    	
	    	return ans;
	    }
	    
	    public void dfs(Map<Integer,List<Integer>> pair,String s,List<String> nowAns,List<List<String>> ans,int index){
	    	if(index==s.length()){
	    		ans.add(new ArrayList<>(nowAns));
	    		return;
	    	}
	    	
	    	List<Integer> toList=pair.get(index);
	    	
	    	for(int i=0;i<toList.size();i++){
	    		nowAns.add(s.substring(index, toList.get(i)+1));
	    		dfs(pair, s, nowAns, ans, toList.get(i)+1);
	    		nowAns.remove(nowAns.size()-1);
	    	}
	    }
	    
	    public Map<Integer,List<Integer>> getPalindrome(String s) {
	        if(s.equals("")||s==null)
				return Collections.emptyMap();
	        
	        Map<Integer,List<Integer>> ans=new HashMap<>();
	        
	        for(int i=0;i<s.length();i++){
	            expand(s,i,i,ans);
	            expand(s,i,i+1,ans);
	        }
	        
	        return ans;
	    }

	    public void expand(String s,int l, int r,Map<Integer,List<Integer>> ans){
	        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
	        	
	        	List<Integer> bs=ans.get(l);
	        	if(bs==null){
	        		bs=new ArrayList<Integer>();
	        		ans.put(l, bs);
	        	}
	        	
	        	bs.add(r);
	        	
	            l--;
	            r++;
	        }
	    }
	    
	}
	
}
