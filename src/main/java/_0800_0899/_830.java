package _0800_0899;

import java.util.ArrayList;
import java.util.List;

public class _830 {
	
	class Solution {
		public List<List<Integer>> largeGroupPositions(String S) {
			
			List<List<Integer>> ans = new ArrayList<>();
			
			if (S.length() < 3) {
				return ans;
			}
			
			char	c		= S.charAt(0);
			int		from	= 0;
			
			for (int i = 1; i < S.length(); ++i) {
				if (c != S.charAt(i)) {
					if (i - from >= 3) {
						List<Integer> temp = new ArrayList<>();
						temp.add(from);
						temp.add(i - 1);
						ans.add(temp);
					}
					c		= S.charAt(i);
					from	= i;
				}
			}
			
			if (S.length() - from >= 3) {
				List<Integer> temp = new ArrayList<>();
				temp.add(from);
				temp.add(S.length() - 1);
				ans.add(temp);
			}
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new _830().new Solution().largeGroupPositions("aaa"));
	}
	
}
