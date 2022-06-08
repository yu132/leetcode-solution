package _0600_0699;

public class _680 {
	
	class Solution {
		
		public boolean validPalindrome(String s) {
			
			for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
				if (s.charAt(i) != s.charAt(j)) {//不相等时，左右选择一个干掉，剩下可以即可
					
					boolean flag = true;
					for (int ix = i, jx = j - 1; ix < jx; ++ix, --jx) {
						if (s.charAt(ix) != s.charAt(jx)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						return true;
					}
					
					flag = true;
					for (int ix = i + 1, jx = j; ix < jx; ++ix, --jx) {
						if (s.charAt(ix) != s.charAt(jx)) {
							flag = false;
							break;
						}
					}
					
					return flag;
				}
			}
			
			return true;
		}
	}
	
}
