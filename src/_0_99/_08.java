package _0_99;

import java.math.BigInteger;

public class _08 {

	public static int myAtoi(String str) {
		
		str=str.trim();
	    
		if(str.length()==0)
			return 0;
		
		BigInteger num=null;
		if(str.charAt(0)=='-'){
			for(int i=1;i<str.length();i++){
				if(str.charAt(i)>='0'&&str.charAt(i)<='9');
				else{
					if(i==1)
						return 0;
					num=new BigInteger('-'+str.substring(1, i));
					break;
				}
			}
			if(num==null){
				if(str.length()==1)
					return 0;
				num=new BigInteger('-'+str.substring(1, str.length()));
			}
		}else{
			if(str.charAt(0)=='+'){
				for(int i=1;i<str.length();i++){
					if(str.charAt(i)>='0'&&str.charAt(i)<='9');
					else{
						if(i==1)
							return 0;
						num=new BigInteger(str.substring(1, i));
						break;
					}
				}
				if(num==null){
					if(str.length()==1)
						return 0;
					num=new BigInteger(str.substring(1, str.length()));
				}
			}else{
				for(int i=0;i<str.length();i++){
					if(str.charAt(i)>='0'&&str.charAt(i)<='9');
					else{
						if(i==0)
							return 0;
						num=new BigInteger(str.substring(0, i));
						break;
					}
				}
				if(num==null){
					num=new BigInteger(str.substring(0, str.length()));
				}
			}
		}
		
		if(num.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0)
			return Integer.MAX_VALUE;
		else if(num.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<0)
			return Integer.MIN_VALUE;
		else
			return num.intValue();
			
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("+"));
	}
	
}
