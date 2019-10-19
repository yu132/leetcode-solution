package _0900_0999;

import java.util.Arrays;

public class _977 {

	class Solution {
	    public int[] sortedSquares(int[] A) {
	    	int loc=Arrays.binarySearch(A, 0);
	    	
	    	if(loc<0)
	    		loc=-loc-1;
	    	
	    	int[] res=new int[A.length];
	    	
	    	int l=loc-1,r=loc,index=0;
	    	while(index<res.length&&(l>=0||r<A.length)){
	    		if(l<0){
	    			res[index++]=A[r]*A[r++];
	    		}else if(r>=A.length){
	    			res[index++]=A[l]*A[l--];
	    		}else{
	    			if(-A[l]>=A[r])
	    				res[index++]=A[r]*A[r++];
	    			else
	    				res[index++]=A[l]*A[l--];
	    		}
	    	}
	    	
	    	return res;
	    }
	}
	
}
