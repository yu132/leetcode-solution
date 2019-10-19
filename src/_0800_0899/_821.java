package _0800_0899;

import java.util.Arrays;

public class _821 {
	
	class Solution {
		public int[] shortestToChar(String S, char C) {
			int[] array = new int[S.length()];
			Arrays.fill(array, Integer.MAX_VALUE);
			
			int index = S.indexOf(C);
			for (int i = 0; i <= index; ++i) {
				array[i] = index - i;
			}
			
			for (int i = index + 1, count = 1; i < S.length(); ++i) {
				if (S.charAt(i) == C) {
					count = 0;
					int back = 0;
					while (count < array[i - back]) {
						array[i - back] = count;
						++back;
						++count;
					}
					count = 1;
				} else {
					array[i] = count;
					++count;
				}
			}
			
			return array;
		}
	}
	
}
