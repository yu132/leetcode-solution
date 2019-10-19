package _0900_0999;

public class _900 {
	
	class RLEIterator {
		
		private int indexForCount=0;
		
		private int indexForLocation=0;
		
		private int[] A;

	    public RLEIterator(int[] A) {
	        this.A=A;
	    }
	    
	    public int next(int n) {
	    	if(indexForLocation>=A.length)
    			return -1;
	    	
	    	indexForCount+=n;
	    	
	    	while(A[indexForLocation]<indexForCount){
	    			
	    		indexForCount-=A[indexForLocation];
	    		indexForLocation+=2;
	    		
	    		if(indexForLocation>=A.length)
	    			return -1;
	    	}
	    	
	        return A[indexForLocation+1];
	    }
	}
	
}
