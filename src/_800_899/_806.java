package _800_899;

public class _806 {
	
	class Solution {
		public int[] numberOfLines(int[] widths, String S) {
			int	nowWidth	= 100;
			int	line		= 0;
			for (char ch : S.toCharArray()) {
				nowWidth += widths[ch - 'a'];
				if (nowWidth > 100) {
					++line;
					nowWidth = widths[ch - 'a'];
				}
			}
			return new int[] {
					line, nowWidth
			};
		}
	}
	
}
