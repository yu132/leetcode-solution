package _800_899;

import java.util.Arrays;

public class _893 {
	
	class Solution {
		
		public final class WeightedUnionFind {
			
			private int[]	size;
			
			protected int	count;
			
			protected int[]	uf;
			
			public WeightedUnionFind(int typeNumber) {
				super();
				this.uf	= new int[typeNumber];
				count	= typeNumber;
				for (int i = 0; i < typeNumber; i++) {
					uf[i] = i;
				}
				size	= new int[typeNumber];
				count	= typeNumber;
				Arrays.fill(size, 1);
			}
			
			public boolean connected(int element1, int element2) {
				return find(element1) == find(element2);
			}
			
			public int count() {
				return count;
			}
			
			public int find(int element) {
				return uf[element] == element ? element : (uf[element] = find(uf[element]));
			}
			
			public void union(int element1, int element2) {
				int	type1	= find(element1);
				int	type2	= find(element2);
				
				if (type1 == type2)
					return;
				
				if (size[type1] < size[type2]) {
					uf[type1]	= type2;
					size[type2]	+= size[type1];
				} else {
					uf[type2]	= type1;
					size[type1]	+= size[type2];
				}
				--count;
			}
		}
		
		public int numSpecialEquivGroups(String[] A) {
			
			int[][][] sum = new int[A.length][2][26];
			
			for (int x = 0; x < A.length; ++x) {
				for (int i = 0; i < A[x].length(); ++i) {
					++sum[x][i % 2][A[x].charAt(i) - 'a'];
				}
			}
			
			WeightedUnionFind uf = new WeightedUnionFind(A.length);
			
			for (int i = 0; i < A.length; ++i) {
				for (int j = i + 1; j < A.length; ++j) {
					if (uf.connected(i, j)) {
						continue;
					}
					if (uf.find(i) != i || uf.find(j) != j) {
						if (uf.find(i) != uf.find(j)) {
							continue;
						}
					}
					
					if (Arrays.equals(sum[i][0], sum[j][0])
							&& Arrays.equals(sum[i][1], sum[j][1])) {
						uf.union(i, j);
					}
				}
			}
			
			return uf.count;
		}
	}
	
	public static void main(String[] args) {
		int i = new _893().new Solution()
				.numSpecialEquivGroups(new String[]
				{ "a", "b", "c", "a", "c", "c" });
		System.out.println(i);
	}
	
}
