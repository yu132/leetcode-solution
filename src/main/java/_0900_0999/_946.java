package _0900_0999;

public class _946 {

	class Solution {
	    public boolean validateStackSequences(int[] pushed, int[] popped) {
	    	
	        int[] stack=new int[pushed.length];
	        int index=0;
	        
	        int ipush=0;
	        int ipop=0;
	        
	        while(true){
	        	if(ipop==popped.length)
		        	return true;
	        	
	        	if(index==0||stack[index-1]!=popped[ipop]){
	        		
	        		if(ipush==pushed.length)
	        			return false;
	        		
	        		stack[index++]=pushed[ipush++];
	        	}else{
	        		--index;
	        		++ipop;
	        	}
	        }
	        
	    }
	}
	
}
