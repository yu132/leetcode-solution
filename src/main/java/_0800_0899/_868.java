package _0800_0899;

public class _868 {
	
	class Solution {
		public int binaryGap(int N) {
			
			String	s		= Integer.toBinaryString(N);
			
			int		index	= s.indexOf('1');
			
			if (index < 0) {
				return 0;
			}
			
			int max = 0;
			for (int i = index + 1; i < s.length(); ++i) {
				if (s.charAt(i) == '1') {
					max		= Math.max(max, i - index);
					index	= i;
				}
			}
			
			return max;
			
		}
	}
	
}
