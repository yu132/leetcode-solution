package _0900_0999;

public class _991 {
/*  v1
	class Solution {
	    public int brokenCalc(int X, int Y) {
	        if(X>Y)
	        	return X-Y;
	        if(X==Y)
	        	return 0;
	        
	        if(Y%2==0)
	        	return brokenCalc(X,Y/2)+1;
	        else 
	        	return brokenCalc(X, (Y+1)/2)+2;
	    }
	}*/
	
	class Solution {
	    public int brokenCalc(int X, int Y) {
	        int count=0;
	        
	        while(Y>X){
	        	if(Y%2==0){
	        		Y/=2;
	        		++count;
	        	}else{
	        		Y=Y/2+1;
	        		count+=2;
	        	}
	        }
	        
	        return count+Math.max(0, X-Y);
	    }
	}
	
}
