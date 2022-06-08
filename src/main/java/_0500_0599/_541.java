package _0500_0599;

public class _541 {
	
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
		
		public String reverseStr(String s, int k) {
			
			char[] array = s.toCharArray();
			
			int c = s.length() / k;
			
			for (int i = 0; i < c; ++i) {
				if (i % 2 == 0) {
					reverse(array, i * k, k);
				}
			}
			
			if (c % 2 == 0) {
				reverse(array, c * k, s.length() - c * k);
			}
			
			return String.valueOf(array);
		}
	}
	
}
