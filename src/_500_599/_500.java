package _500_599;

import java.util.Arrays;

public class _500 {
	
	class Solution {
		
		int[] map = new int[] {
				2, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1, 1, 3, 3, 3, 3, 2, 3,
				3, 1, 3, 1, 3, 1
		};
		
		public String[] findWords(String[] words) {
			String[] ans = new String[words.length];
			int len = 0;
			
			l: for (int i = 0; i < words.length; ++i) {
				if (words[i].length() == 0) {
					ans[len++] = words[i];
				} else {
					char word = words[i].charAt(0);
					int type = map[(word >= 'a' ? word - 'a' : word - 'A')];
					for (int j = 1; j < words[i].length(); ++j) {
						char word1 = words[i].charAt(j);
						if (type != map[(word1 >= 'a' ? word1 - 'a' : word1 - 'A')])
							continue l;
					}
					ans[len++] = words[i];
				}
			}
			
			return Arrays.copyOf(ans, len);
		}
	}
	
}
