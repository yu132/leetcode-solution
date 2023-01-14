package old._0400_0499;

public class _470 {
	
	public int rand7() {
		return 0;
	}
	
	class SolBase {}
	
	class Solution extends SolBase {
		public int rand10() {
			int r1 = rand7(), r2 = rand7();
			if (r1 > 4 && r2 < 4) {
				return rand10();
			} else {
				return (r1 + r2) % 10 + 1;
			}
		}
	}
}
