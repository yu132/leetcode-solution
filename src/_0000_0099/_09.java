package _0000_0099;

public class _09 {

	 public static boolean isPalindrome(int x) {
		 
		 if(x<0)
			 return false;
		 
		 int l=0;
		 
		 int temp=x;
		 for(;temp!=0;l++){
			 temp/=10;
		 }
		 
		 int temp1=x;
		 int temp2=x;
		 
		 for(int i=0;i<l/2;i++){
			 if(temp1/(int)Math.pow(10, l-i-1)!=temp2%10){
				 return false;
			 }
			 temp1=temp1-temp1/(int)Math.pow(10, l-i-1)*(int)Math.pow(10, l-i-1);
			 temp2=temp2/10;
		 }
	     return true;
	     
	 }
	 
	 public static void main(String[] args) {
		System.out.println(isPalindrome(5));
	}
	
}
