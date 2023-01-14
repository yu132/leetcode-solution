package old._1000_1099;

import java.util.Arrays;

public class _1005 {
	
	public static void main(String[] args) {
		System.out.println(new _1005().new Solution().largestSumAfterKNegations(
				new int[]{-8,3,-5,-3,-5,-2}, 1));
	}
	

	class Solution {
	    public int largestSumAfterKNegations(int[] A, int K) {
	    	
	    	Arrays.sort(A);
	    	
	    	int sum=0;
	    	
	    	boolean fz=false;
	    	boolean fp=true;
	    	
	    	int n1Index=-1,p1Index=-1;
	    	
	    	for(int i=0;i<A.length;++i){
	    		if(A[i]==0){
	    			fz=true;
	    		}else if(A[i]<0){
	    			n1Index=i;
	    			if(K>0){
	    				sum+=-A[i];
	    				--K;
	    			}else
	    				sum+=A[i];
    			}else{
    				if(fp){
    					fp=false;
    					p1Index=i;
    				}
    				sum+=A[i];
    			}
	    	}
	    	
	    	System.out.println(n1Index+" "+p1Index+" "+sum);
	    	
	    	System.out.println(Arrays.toString(A));
	    	
	    	if(K<=0||K%2==0||fz)
	    		return sum;
	    	else{
	    		if(n1Index<0)
	    			return sum-2*A[p1Index];
	    		else if(p1Index>=A.length)
	    			return sum+2*A[n1Index];
	    		else
	    			return Math.max(sum-2*A[p1Index], sum+2*A[n1Index]);
	    	}
	    
	    	
	    	
	    }
	}
	
}
