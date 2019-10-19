package _0400_0499;

import java.util.HashMap;
import java.util.Map;

public class _454 {

	class Solution {
	    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	        
	    	Map<Integer,Integer> sumAB=new HashMap<>();
	    	for(int i=0;i<A.length;i++)
	    		for(int j=0;j<B.length;j++){
	    			int sum=A[i]+B[j];
	    			sumAB.put(sum, sumAB.getOrDefault(sum, 0)+1);
	    		}
	    	
	    	int count=0;
	    	for(int i=0;i<C.length;i++)
	    		for(int j=0;j<D.length;j++)
	    			count+=sumAB.getOrDefault(-C[i]-D[j], 0);
	    		
	    	return count;
	    }
	}
	
}
