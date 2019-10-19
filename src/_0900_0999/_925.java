package _0900_0999;

public class _925 {

	class Solution {
	    public boolean isLongPressedName(String name, String typed) {
	    	
	    	for(int i=0,j=0;i<name.length();){
	    		
	    		if(j>=typed.length())
	    			return false;
	    		
	    		if(name.charAt(i)==typed.charAt(j)){
	    			++i;
	    			++j;
	    		}else{
	    			if(i!=0&&name.charAt(i-1)==typed.charAt(j)){
	    				++j;
	    			}else{
	    				return false;
	    			}
	    		}
	    	}
	    	
	    	return true;
	    }
	}
	
}
