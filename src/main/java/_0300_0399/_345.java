package _0300_0399;

public class _345 {

	class Solution {
	    public String reverseVowels(String s) {
	        char[] cArray=s.toCharArray();
	        
	        int l=0, r=cArray.length-1;
	        while(l<r){
	        	while(l<r&&!isAEIOU(cArray[l]))
	        		++l;
	        	while(l<r&&!isAEIOU(cArray[r]))
	        		--r;
	        	if(l<r){
	        		char temp=cArray[l];
	        		cArray[l]=cArray[r];
	        		cArray[r]=temp;
	        		++l;
	        		--r;
	        	}
	        }
	        
	        return new String(cArray);
	    }
	    
	    public boolean isAEIOU(char c){
	    	return (c<='z'&&(c=='e'||c=='a'||c=='o'||c=='i'||c=='u'))
	    			||c=='E'||c=='A'||c=='O'||c=='I'||c=='U';
	    }
	}
	
}
