package _1000_1099;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1002 {

	class Solution {
	    public List<String> commonChars(String[] A) {
	    	
	    	if(A.length==0)
	    		return Collections.emptyList();
	    	
	        int[] counter=new int[26];
	        
	        for(int i=0;i<A[0].length();++i)
	        	++counter[A[0].charAt(i)-'a'];
	        
	        for(int i=1;i<A.length;++i){
		        int[] counterTemp=new int[26];
		        
		        for(int j=0;j<A[i].length();++j)
		        	++counterTemp[A[i].charAt(j)-'a'];
		        
		        for(int j=0;j<26;++j)
		        	counter[j]=Math.min(counter[j], counterTemp[j]);
	        }
	        
	        List<String> ans=new ArrayList<>();
	        
	        for(int i=0;i<26;++i){
	        	while(counter[i]!=0){
	        		ans.add(String.valueOf((char)('a'+i)));
	        		--counter[i];
	        	}
	        }
	        
	        return ans;
	    }
	}
	
}
