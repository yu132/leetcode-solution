package _0800_0899;

public class _849 {
	
	class Solution {
		public int maxDistToClosest(int[] seats) {
			int f = 0;
			while (seats[f] == 0) {
				++f;
			}
			int b = seats.length - 1;
			while (seats[b] == 0) {
				--b;
			}
			int	max		= Math.max(f, seats.length - 1 - b);
			int	count	= 0;
			for (int i = f + 1; i <= b; ++i) {
				if (seats[i] == 0) {
					++count;
				} else {
					max		= Math.max(max, (count + 1) / 2);
					count	= 0;
				}
			}
			return max;
		}
	}
	
}
