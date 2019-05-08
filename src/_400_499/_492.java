package _400_499;

public class _492 {
/* v1
	class Solution {
	    public int[] constructRectangle(int area) {
	        int n=(int) Math.sqrt(area);
	        
	        int w=n,l=n;
	        
	        while(true){
	        	int nowArea=w*l;
	        	
	        	if(nowArea==area)
	        		return new int[]{l,w};
	        	else if(nowArea>area)
	        		w--;
	        	else
	        		l++;
	        }
	    }
	}*/
	
	class Solution {
	    public int[] constructRectangle(int area) {
	    	int n=(int) Math.sqrt(area);
	    	
	    	for(int i=n;i>0;i--){
	    		if(area%i==0){
	    			return new int[]{area/i,i};
	    		}
	    	}
	    	throw new IllegalArgumentException();
	    }
	}
	
}
