package _1000_1099;

import java.util.Arrays;

public class _1033 {
	
	class Solution {
		public int[] numMovesStones(int a, int b, int c) {
			int[] temp = { a, b, c };
			Arrays.sort(temp);
			
			int max = Math.max(0, temp[2] - temp[1] - 1) + Math.max(0, temp[1] - temp[0] - 1);
			
			if (temp[1] - temp[0] <= 2 || temp[2] - temp[1] <= 2) {
				if (temp[1] - temp[0] == 1 && temp[2] - temp[1] == 1) {
					return new int[] { 0, max };
				}
				return new int[] { 1, max };
			} else {
				return new int[] { 2, max };
			}
		}
	}
	
}
