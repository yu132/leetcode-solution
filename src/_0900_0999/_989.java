package _0900_0999;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _989 {

	class Solution {
	    public List<Integer> addToArrayForm(int[] A, int K) {
	        
	    	int carry=0;
	    	int index=A.length-1;
	    	while(K!=0&&index!=-1){
	    		int ki=K%10;
	    		
	    		int n=A[index]+ki+carry;
	    		
	    		carry=n/10;
	    		A[index]=n%10;
	    		
	    		--index;
	    		K/=10;
	    	}
	    	
	    	if(index!=-1){
	    		while(index!=-1&&carry!=0){
		    		
		    		int n=A[index]+carry;
		    		
		    		carry=n/10;
		    		A[index]=n%10;
		    		
		    		--index;
	    		}
	    	}
	    	
	    	List<Integer> ans=new ArrayList<>(Math.max(12, A.length));
	    	
	    	if(index==-1){
	    		
	    		while(K!=0){
		    		int ki=K%10;
		    		
		    		int n=carry+ki;
		    		
		    		carry=n/10;
		    		ans.add(n%10);
		    		
		    		K/=10;
		    	}
	    	}
	    	
	    	if(carry==1)
	    		ans.add(1);
	    	
	    	Collections.reverse(ans);
	    	
	    	for(int i=0;i<A.length;++i){
	    		ans.add(A[i]);
	    	}
	    	
	    	
	    	
	    	return ans;
	    }
	}
	
}
