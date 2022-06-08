package _0400_0499;

public class _458 {

//	class Solution {
//	    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//	    	int decimal = minutesToTest/minutesToDie + 1;
//	        int pig = (int) Math.ceil(Math.log(buckets)/Math.log(decimal));
//	        return pig;
//	    }
//	    
//	    
//	}
	
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie + 1;
        for (int i = 0, max = 1;; i++, max *= k) {
            if (max >= buckets) {
                return i;
            }
        } 
    }
	
}
