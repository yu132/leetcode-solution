package _0_99;

public class _07 {
	 public static int reverse(int x) {
		 
		 String s=Integer.valueOf(x).toString();
		 
		 long temp;
		 
		 if(s.charAt(0)=='-'){
			temp = Long.parseLong('-'+new StringBuilder(s.substring(1, s.length())).reverse().toString());
		 }else{
			temp= Long.parseLong(new StringBuilder(s.substring(0, s.length())).reverse().toString());
		 }
		 
		 if(temp>Integer.MAX_VALUE||temp<Integer.MIN_VALUE)
			 return 0;
		 else
			 return (int)temp;
		 
	 }
	 
	 public static void main(String[] args) {
		System.out.println(reverse(1111111119));
	}
}
