package _0400_0499;

import java.util.Arrays;

public class _455 {

	class Solution {
	    public int findContentChildren(int[] g, int[] s) {
	        Arrays.sort(g);
	        Arrays.sort(s);
	        
	        int count=0;
	        
	        for(int i=0,j=0;i<g.length&&j<s.length;){
	        	if(s[j]>=g[i]){
	        		++count;
	        		++i;
	        		++j;
	        	}else{
	        		++j;
	        	}
	        }
	        
	        return count;
	    }
	}
	
}
