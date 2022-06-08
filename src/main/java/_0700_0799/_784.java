package _0700_0799;

import java.util.ArrayList;
import java.util.List;

public class _784 {
	
	class Solution {
		
		public final static int DIFF_a_A = 'a' - 'A';
		
		private void helper(char[] array, List<String> ans, int index) {
			if (index == array.length) {
				ans.add(String.valueOf(array));
				return;
			}
			if (array[index] >= 'a' && array[index] <= 'z') {
				array[index] -= DIFF_a_A;
				helper(array, ans, index + 1);
				array[index] += DIFF_a_A;
			}
			helper(array, ans, index + 1);
		}
		
		public List<String> letterCasePermutation(String S) {
			
			char[]			array	= S.toLowerCase().toCharArray();
			List<String>	ans		= new ArrayList<>(1000);
			
			helper(array, ans, 0);
			
			return ans;
		}
	}
	
}
