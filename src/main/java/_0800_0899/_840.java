package _0800_0899;

public class _840 {
	
	class Solution {
		
		int[][][] toCheck = new int[][][] {
				{
						{ 0, 0 },
						{ 0, 1 },
						{ 0, 2 }
				},
				{
						{ 1, 0 },
						{ 1, 1 },
						{ 1, 2 }
				},
				{
						{ 2, 0 },
						{ 2, 1 },
						{ 2, 2 }
				},
				{
						{ 0, 0 },
						{ 1, 0 },
						{ 2, 0 }
				},
				{
						{ 0, 1 },
						{ 1, 1 },
						{ 2, 1 }
				},
				{
						{ 0, 2 },
						{ 1, 2 },
						{ 2, 2 }
				},
				{
						{ 0, 0 },
						{ 1, 1 },
						{ 2, 2 }
				},
				{
						{ 2, 0 },
						{ 1, 1 },
						{ 0, 2 }
				},
		};
		
		public int numMagicSquaresInside(int[][] grid) {
			
			int count = 0;
			
			for (int i = 0; i < grid.length - 2; ++i) {
				l: for (int j = 0; j < grid[i].length - 2; ++j) {
					
					boolean	flag		= true;
					int		sumCheck	= 0;
					
					int[]	check		= new int[10];
					
					for (int x1 = 0; x1 < 8; ++x1) {
						
						int sum = 0;
						
						for (int x2 = 0; x2 < 3; ++x2) {
							int value = grid[i + toCheck[x1][x2][0]][j + toCheck[x1][x2][1]];
							sum += value;
							
							if (x1 < 3) {
								if (value < 1 || value > 9) {
									continue l;
								}
								if (++check[value] == 2) {
									continue l;
								}
							}
						}
						
						if (flag) {
							flag		= false;
							sumCheck	= sum;
						} else {
							if (sum != sumCheck) {
								continue l;
							}
						}
					}
					
					++count;
				}
			}
			
			return count;
		}
	}
	
}
