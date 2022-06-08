package _1100_1199;

public class _1128 {
	
	class Solution {
		public int numEquivDominoPairs(int[][] dominoes) {
			
			int[][] temp = new int[10][10];
			for (int i = 0; i < dominoes.length; ++i) {
				++temp[dominoes[i][0]][dominoes[i][1]];
			}
			
			int count = 0;
			for (int i = 1; i < 10; ++i) {
				for (int j = i; j < 10; ++j) {
					if (i == j) {
						count += (temp[i][j] - 1) * temp[i][j] / 2;
					} else {
						count	+= temp[i][j] * temp[j][i];
						count	+= (temp[i][j] - 1) * temp[i][j] / 2;
						count	+= (temp[j][i] - 1) * temp[j][i] / 2;
					}
				}
			}
			
			return count;
		}
	}
	
}
