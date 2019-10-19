package _0800_0899;

import java.util.HashSet;
import java.util.Set;

public class _888 {
	
	class Solution {
		public int[] fairCandySwap(int[] A, int[] B) {
			
			Set<Integer>	set		= new HashSet<>((int) (B.length / 0.75));
			
			int				diff	= 0;
			
			for (int each : A) {
				diff += each;
			}
			
			for (int each : B) {
				diff -= each;
				set.add(each);
			}
			
			for (int each : A) {
				if (set.contains(each - diff / 2)) {
					return new int[] { each, each + diff };
				}
			}
			
			return null;
		}
	}
	
}
