package _600_699;

public class _696 {
	
	class Solution {
		public int countBinarySubstrings(String s) {
			
			if (s.length() == 0) {
				return 0;
			}
			
			boolean	is1now	= s.charAt(0) == '1';
			
			int		count1	= is1now ? 1 : 0;
			int		count0	= 1 - count1;
			
			int		ans		= 0;
			
			for (int i = 1; i < s.length(); ++i) {
				if (s.charAt(i) == '1') {
					if (is1now) {
						++count1;
					} else {
						ans		+= Math.min(count0, count1);
						is1now	= true;
						count1	= 1;
					}
				} else {//=='0'
					if (!is1now) {
						++count0;
					} else {
						ans		+= Math.min(count0, count1);
						is1now	= false;
						count0	= 1;
					}
				}
			}
			
			ans += Math.min(count0, count1);
			
			return ans;
		}
	}
	
	public static void main(String[] args) {
		new _696().new Solution().countBinarySubstrings("10101");
	}
	
}
