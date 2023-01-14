package old._0200_0299;

public class _275 {

	class Solution {
	    public int hIndex(int[] citations) {
	    	
	    	if(citations.length==0)
	    		return 0;
	    	
	    	if(citations[citations.length-1]==0)
	    		return 0;
	    	
	        int l=0,r=citations.length-1;
	        
	        while(l<r){
	        	
	        	int mid=(l+r)>>>1;
	        	
	        	if(citations[mid]>=citations.length-mid)
	        		r=mid;
	        	else
	        		l=mid+1;
	        }
	        
	        return citations.length-l;
	    }
	}
	
}
