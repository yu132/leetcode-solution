package _400_499;

public class _400 {

	class Solution {
	    public int findNthDigit(int n) {
	        if(n<10) return n;
	        
	        long length=0, c=9, digit=1;
	        
	        for(;length+c*digit<n;++digit){
	        	length+=c*digit;
	        	c*=10;
	        }
	        
	        long num=(long) (Math.pow(10,digit-1)-1+(n-length+1)/digit);
	        
	        System.out.println(num);
	        
	        int index=(int) ((n-length-1)%digit);
	        
	        return new Long(num).toString().charAt(index)-'0';
	    }
	}
	
}
