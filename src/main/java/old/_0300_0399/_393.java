package old._0300_0399;

public class _393 {

	class Solution {

		final int[][]	minDigitRange	= {
				{
						0x0000000, 0x0000007F
				},
				{
						0x00000C0, 0x000000DF
				},
				{
						0x00000E0, 0x000000EF
				},
				{
						0x00000F0, 0x000000F7
				},
		};

		final int[]		otherDigitRange	= {
				0x0000080, 0x000000BF
		};

		public boolean validUtf8(int[] data) {
			l: for (int i = 0; i < data.length;) {
				for (int j = 0; j < minDigitRange.length; ++j) {
					if (data[i] >= minDigitRange[j][0] && data[i] <= minDigitRange[j][1]) {
						if (i + j >= data.length)
							return false;
						for (int k = 1; k <= j; ++k) {
							if (data[i + k] < otherDigitRange[0]
									|| data[i + k] > otherDigitRange[1])
								return false;
						}
						i += j + 1;
						continue l;
					}
				}
				return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		for (int[] each : new int[][] {
				{
						0x0000000, 0x0000007F
				},
				{
						0x00000C0, 0x000000DF
				},
				{
						0x00000E0, 0x000000EF
				},
				{
						0x00000F0, 0x000000F7
				},
		}) {
			System.out.println(Integer.toBinaryString(each[0]));
			System.out.println(Integer.toBinaryString(each[1]));
			System.out.println();
		}

		for (int i : new int[] {
				0x0000080, 0x000000BF
		}) {
			System.out.println(Integer.toBinaryString(i));
		}
		System.out.println();

		for (int i : new int[] {
				230, 136, 145
		}) {
			System.out.println(Integer.toBinaryString(i));
		}
		System.out.println(new _393().new Solution().validUtf8(new int[] {
				230, 136, 145
		}));
	}

}
