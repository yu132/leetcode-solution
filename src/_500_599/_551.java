package _500_599;

public class _551 {
	
	class Solution {
		public boolean checkRecord(String s) {
			
			int conCountL = 0;
			int countA = 0;
			
			for (char c : s.toCharArray()) {
				if (c == 'A') {
					conCountL = 0;
					++countA;
					if (countA > 1) {
						return false;
					}
				} else if (c == 'L') {
					++conCountL;
					if (conCountL == 3) {
						return false;
					}
				} else {//P
					conCountL = 0;
				}
			}
			
			return true;
		}
	}
	
}
