package _0200_0299;

import java.util.HashMap;
import java.util.Map;

public class _290 {

	class Solution {
	    public boolean wordPattern(String pattern, String str) {
	        String[] spilt=str.split(" ");
	        
	        if(pattern.length()!=spilt.length)
	        	return false;
	        
	        String[] map=new String[26];
	        
	        Map<String,Integer> mapInv=new HashMap<>();
	        
	        for(int i=0;i<spilt.length;i++){
	        	
	        	int index=pattern.charAt(i)-'a';
	        	
	        	if(map[index]!=null){
	        		if(!map[index].equals(spilt[i]))
	        			return false;
	        		if(mapInv.getOrDefault(spilt[i], index)!=index)
	        			return false;
	        	}else{
	        		map[index]=spilt[i];
	        		
	        		if(mapInv.getOrDefault(spilt[i], index)!=index)
	        			return false;
	        		
	        		mapInv.put(spilt[i], index);
	        	}
	        }
	        
	        return true;
	    }
	}
	
}
