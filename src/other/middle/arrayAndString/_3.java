package other.middle.arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _3 {

	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	Map<String,List<String>> map=new HashMap<>();
	    	
	        for(int i=0;i<strs.length;i++){
	        	char[] chs=strs[i].toCharArray();
	        	
	        	Arrays.sort(chs);
	        	
	        	String key=String.valueOf(chs);
	        	
	        	List<String> list=map.get(key);
	        	
	        	if(list==null){
	        		list=new ArrayList<>();
	        		map.put(key, list);
	        	}
	        	
	        	list.add(strs[i]);
	        }
	        
	        List<List<String>> ans=new ArrayList<>();
	        
	        for(List<String> list:map.values()){
	        	ans.add(list);
	        }
	        
	        return ans;
	    }
	}
	
}
