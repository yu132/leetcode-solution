package _1000_1099;

public class _1071 {
	
	class Solution {
		
		public int gcd(int m, int n) {
			int r;
			while (n > 0) {
				r	= m % n;
				m	= n;
				n	= r;
			}
			return m;
		}
		
		
		public String gcdOfStrings(String str1, String str2) {
			
			int gcd = gcd(str1.length(), str2.length());
			
			for (int i = gcd; i < str1.length(); ++i) {
				if (str1.charAt(i) != str1.charAt(i % gcd)) {
					return "";
				}
			}
			
			for (int i = gcd; i < str2.length(); ++i) {
				if (str2.charAt(i) != str1.charAt(i % gcd)) {
					return "";
				}
			}
			
			return str1.substring(0, gcd);
		}
	}
	
}
