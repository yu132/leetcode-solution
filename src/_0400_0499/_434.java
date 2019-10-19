package _0400_0499;

public class _434 {

	class Solution {
	    public int countSegments(String s) {
	        int count=0;
	        boolean flag=false;
	        for(int i=0;i<s.length();i++){
	        	if(s.charAt(i)==' '){
	        		if(flag){
		        		++count;
		        		flag=false;
	        		}
	        	}else
	        		flag=true;
	        }
	        return flag?count+1:count;
	    }
	}
	
}
