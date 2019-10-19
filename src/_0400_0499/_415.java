package _0400_0499;

import java.math.BigInteger;

public class _415 {
/* v1 fast
	class Solution {
	    public String addStrings(String num1, String num2) {
	        int len1=num1.length()-1;
	        int len2=num2.length()-1;
	        
	        StringBuilder sb=new StringBuilder(Math.max(num1.length(), num2.length())+1);
	        
	        int carry=0;
	        
	        while(len1!=-1||len2!=-1){
	        	
	        	int num;
	        	if(len1==-1)
	        		num=num2.charAt(len2--)-'0'+carry;
	        	else if(len2==-1)
	        		num=num1.charAt(len1--)-'0'+carry;
	        	else
	        		num=num1.charAt(len1--)-'0'+num2.charAt(len2--)-'0'+carry;
	        	
	        	sb.append(num%10);
        		carry=num/10;
	        }
	        
	        if(carry==1)
	        	sb.append(1);
	        
	        return sb.reverse().toString();
	    }
	}*/
	
	//slow
	class Solution {
	    public String addStrings(String num1, String num2) {
	        return new BigInteger(num1).add(new BigInteger(num2)).toString();
	    }
	}
	
}
