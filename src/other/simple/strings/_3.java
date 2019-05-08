package other.simple.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _3 {

	class Solution {
	    public int firstUniqChar(String s) {
	    	if(s.equals("")||s==null)
	    		return -1;
	    	
	        char[] chars=s.toCharArray();
	        
	        Map<Character,Integer> map=new HashMap<>();
	        
	        for(int i=0;i<chars.length;i++){
	        	if(map.get(chars[i])==null)
	        		map.put(chars[i], i);
	        	else
	        		map.put(chars[i], Integer.MAX_VALUE);
	        }
	        
	        int temp=Collections.min(map.values());
	        
	        return temp==Integer.MAX_VALUE?-1:temp;
	    }
	}
	
}
