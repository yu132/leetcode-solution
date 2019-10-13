package _1000_1099;

public class _1009 {
	
	class Solution {
		public int bitwiseComplement(int N) {
			int mask = 2;
			while (mask <= N)
				mask <<= 1;
			return N ^ mask - 1;
		}
	}
	
}
