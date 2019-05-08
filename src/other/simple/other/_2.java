package other.simple.other;

public class _2 {

	class Solution {
	    public int hammingDistance(int x, int y) {
	        return hammingWeight(x^y);
	    }
	    
	    public int hammingWeight(int n) {
	    	int count=0;
	        while(n!=0)
	        {
	            count++;
	            n=(n-1)&n;
	        }
	        return count;
	    }
	}
	
}
