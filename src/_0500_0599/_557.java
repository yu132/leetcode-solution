package _0500_0599;

public class _557 {
	
	class Solution {
		public void reverse(char[] array, int from, int length) {
			for (int to = from + length - 1, mid = from + (length >> 1); from < mid; ++from, --to)
				swap(array, from, to);
		}
		
		public void swap(char[] array, int x, int y) {
			char num = array[x];
			array[x] = array[y];
			array[y] = num;
		}
		
		public String reverseWords(String s) {
			
			char[] array = s.toCharArray();
			
			int b = 0;
			
			for (int i = 0; i < s.length(); ++i) {
				if (array[i] == ' ') {
					reverse(array, b, i - b);
					b = i + 1;
				}
			}
			
			if (b < array.length) {
				reverse(array, b, array.length - b);
			}
			
			return String.valueOf(array);
		}
	}
	
	
}
