package other.simple.sort;

public class _2 {
	
	class VersionControl{
		boolean isBadVersion(int version){
			return false;
		}
	}

	public class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	    	return firstBadVersion(1,n);
	    }
	    
	    public int firstBadVersion(int f,int b) {
	    	int mid=f+(b-f)/2;
	    	if(!isBadVersion(mid)){//false
	    		if(isBadVersion(mid+1))//true
	    			return mid+1;
	    		
	    		return firstBadVersion(mid+1,b);
	    	}else{//true
	    		if(!isBadVersion(mid-1))//false
	    			return mid;
	    		else
	    			return firstBadVersion(f,mid-1);
	    	}
	    }
	}
	
}
