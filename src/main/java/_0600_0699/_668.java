package _0600_0699;

public class _668 {

	class Solution {
	    public int findKthNumber(int m, int n, int k) {
	        int l=1,r=m*n+1;
	        
	        while(l<r){
	        	int mid=(l+r)>>>1;
	        	
	        	int count=0;
	        	
	        	for(int i=1;i<=m;++i){
	        		int now=Math.min(n, mid/i);
	        		if(now==0)
	        			break;
	        		count+=now;
	        	}
	        	
	        	if(count>=k)
	        		r=mid;
	        	else
	        		l=mid+1;
	        }
	        
	        return l;
	    }
	}
	
}
