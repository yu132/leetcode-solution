package old._0900_0999;

public class _941 {
//  v1
//	class Solution {
//	    public boolean validMountainArray(int[] A) {
//	        
//	        if(A.length<=2)
//	        	return false;
//	        
//	        if(A[0]>=A[1])
//	        	return false;
//	        
//	        boolean flag=true;
//	        
//	        for(int i=1;i<A.length;++i){
//	        	if(flag){
//	        		if(A[i]==A[i-1])
//	        			return false;
//	        		else if(A[i]<A[i-1])
//	        			flag=false;
//	        	}else{
//	        		if(A[i]>=A[i-1])
//	        			return false;
//	        	}
//	        }
//	        
//	        return !flag;
//	    }
//	}
	
	/**
	 * 不需要全部遍历的方法 
	 */
	class Solution {
	    public boolean validMountainArray(int[] A) {
	        if(A.length < 3) return false;
	        int i = 1;
	        while(i < A.length){
	        	if(A[i - 1] < A[i]){
	        		++i;
	        		continue;
	        	}else if(A[i - 1] == A[i])return false;
	        	else break;
	        }
	        if(i == A.length || i == 1)return false;
	        while(i < A.length){
	        	if(A[i - 1] > A[i]){
	        		++i;
	        		continue;
	        	}else if(A[i - 1] == A[i])return false;
	        	else break;
	        }
	        return i == A.length;
	    }
	}
	
}
