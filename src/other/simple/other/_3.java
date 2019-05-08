package other.simple.other;

public class _3 {

	public class Solution {
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
//	    	String str=Integer.toBinaryString(n);
//	    	
//	    	StringBuilder sb=new StringBuilder(32);
//	    	
//	    	for(int i=0;i<32-str.length();i++){
//	    		sb.append("0");
//	    	}
//	    	
//	    	sb.append(str).reverse();
//	    	
//	        return Integer.parseUnsignedInt(sb.toString(),2);
	    	return Integer.reverse(n);
	    }
	}
	
}
