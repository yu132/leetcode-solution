package _0900_0999;

public class _917 {
	
	class Solution {
		
		public boolean isLetter(char ch) {
			if (ch >= 'a' && ch <= 'z') {
				return true;
			} else if (ch >= 'A' && ch <= 'Z') {
				return true;
			}
			return false;
		}
		
		public String reverseOnlyLetters(String S) {
			
			char[]	array	= S.toCharArray();
			
			int		low		= 0, high = S.length() - 1;
			
			while (true) {
				while (low <= high && !isLetter(array[low])) {
					++low;
				}
				while (low <= high && !isLetter(array[high])) {
					--high;
				}
				if (low < high) {
					char temp = array[low];
					array[low]	= array[high];
					array[high]	= temp;
					++low;
					--high;
				} else {
					break;
				}
			}
			
			return String.valueOf(array);
		}
	}
	
}
