package _0800_0899;

public class _832 {
	
	class Solution {
		
		public void reverse(int[] array, int from, int length) {
			for (int to = from + length - 1, mid = from + (length >> 1); from < mid; ++from, --to) {
				swap(array, from, to);
			}
		}
		
		public void swap(int[] array, int x, int y) {
			int num = array[x];
			array[x]	= array[y];
			array[y]	= num;
		}
		
		public int[][] flipAndInvertImage(int[][] A) {
			
			for (int[] each : A) {
				reverse(each, 0, each.length);
			}
			
			for (int i = 0; i < A.length; ++i) {
				for (int j = 0; j < A[i].length; ++j) {
					A[i][j] ^= 1;
				}
			}
			
			return A;
		}
	}
	
}
