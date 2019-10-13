package _1000_1099;

public class _1013 {
	
	class Solution {
		public boolean canThreePartsEqualSum(int[] A) {
			int sum = 0;
			for (int each : A) {
				sum += each;
			}
			if (sum % 3 != 0) {
				return false;
			}
			int		sumd3	= sum / 3;
			int		suml	= 0, il, sumr = 0, ir;
			boolean	f		= false;
			for (il = 0; il < A.length; ++il) {
				suml += A[il];
				if (suml == sumd3) {
					f = true;
					break;
				}
			}
			if (!f) {
				return false;
			}
			f = false;
			for (ir = A.length - 1; ir > il + 1; --ir) {
				sumr += A[ir];
				if (sumr == sumd3) {
					f = true;
					break;
				}
			}
			return f;
		}
	}
	
	public static void main(String[] args) {
		new _1013().new Solution()
				.canThreePartsEqualSum(new int[]
				{ 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 });
	}
}
