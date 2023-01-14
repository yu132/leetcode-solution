package old._0900_0999;

public class _942 {
	
	class Solution {
		public int[] diStringMatch(String S) {
			
			int		low	= 0, high = S.length();
			
			int[]	ans	= new int[S.length() + 1];
			
			for (int i = 0; i < S.length(); ++i) {
				if (S.charAt(i) == 'I') {
					ans[i] = low++;
				} else {
					ans[i] = high--;
				}
			}
			
			ans[S.length()] = low;
			
			return ans;
		}
	}
	
}
