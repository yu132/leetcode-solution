package _0900_0999;

public class _914 {
	
	class Solution {
		
		public boolean hasGroupsSizeX(int[] deck) {
			
			int[] count = new int[10005];
			
			for (int each : deck) {
				++count[each];
			}
			
			int min = 10005;
			
			for (int each : count) {
				if (each > 1) {
					min = Math.min(min, each);
				} else if (each == 1) {
					return false;
				}
			}
			
			l: for (int i = 2; i < 10001; ++i) {
				for (int each : count) {
					if (each % i != 0) {
						continue l;
					}
				}
				return true;
			}
			
			return false;
		}
	}
	
}
