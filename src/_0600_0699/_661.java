package _0600_0699;

public class _661 {
	
	class Solution {
		public int[][] imageSmoother(int[][] M) {
			
			int[]	xx	= {
					-1, 0, 1
			};
			
			int[]	yy	= {
					-1, 0, 1
			};
			
			if (M.length == 0) {
				return M;
			}
			int[][] ans = new int[M.length][M[0].length];
			
			for (int i = 0; i < M.length; ++i) {
				for (int j = 0; j < M[i].length; ++j) {
					int	sum		= 0;
					int	count	= 0;
					
					for (int eachx : xx) {
						
						int nowx = i + eachx;
						
						if (nowx < 0 || nowx >= M.length) {
							continue;
						}
						
						for (int eachy : yy) {
							
							int nowy = j + eachy;
							
							if (nowy < 0 || nowy >= M[0].length) {
								continue;
							}
							
							++count;
							sum += M[nowx][nowy];
							
						}
					}
					
					ans[i][j] = sum / count;
					
				}
			}
			
			return ans;
		}
	}
	
}
