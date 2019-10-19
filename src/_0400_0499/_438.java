package _0400_0499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _438 {
	
	class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			
			int[] countS = new int[26];
			int[] countP = new int[26];
			
			if (s.length() < p.length())
				return Collections.emptyList();
			
			List<Integer> ans = new ArrayList<>();
			
			for (int i = 0; i < p.length(); ++i) {
				++countS[s.charAt(i) - 'a'];
				++countP[p.charAt(i) - 'a'];
			}
			
			if (Arrays.equals(countS, countP)) {
				ans.add(0);
			}
			
			for (int i = p.length(), j = 0; i < s.length(); ++i, ++j) {
				--countS[s.charAt(j) - 'a'];
				++countS[s.charAt(i) - 'a'];
				if (Arrays.equals(countS, countP)) {
					ans.add(j + 1);
				}
			}
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		new _438().new Solution().findAnagrams("cbaebabacd", "abc");
	}
	
}
