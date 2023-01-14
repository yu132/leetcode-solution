package old._0100_0199;

public class _152 {

	class Solution {
		public int maxProduct(int[] nums) {

			if (nums.length == 1)
				return nums[0];

			int from = 0;
			int ans = 0;
			for (int i = 0; i < nums.length; ++i) {
				if (nums[i] == 0) {
					ans = Math.max(ans, maxProductHelper(nums, from, i));
					from = i + 1;
				}
			}

			ans = Math.max(ans, maxProductHelper(nums, from, nums.length));

			return ans;
		}

		public int maxProductHelper(int[] nums, int from, int to) {
			if (from >= to)
				return 0;

			int[] preMul = new int[to - from + 1];

			preMul[0] = 1;

			for (int i = from; i < to; ++i) {
				preMul[i + 1 - from] = preMul[i - from] * nums[i];
			}

			int posMax = 0, posMin = 1;
			int negMax = Integer.MIN_VALUE, negMin = 0;

			for (int i = 1; i < preMul.length; ++i) {
				if (preMul[i] > 0) {
					if (preMul[i] > posMax)
						posMax = preMul[i];
					else if (preMul[i] < posMin)
						posMin = preMul[i];
				} else {
					if (preMul[i] > negMax)
						negMax = preMul[i];
					else if (preMul[i] < negMin)
						negMin = preMul[i];
				}
			}

			int value1 = 0;
			if (posMax != 0 && posMin != Integer.MAX_VALUE)
				value1 = posMax / posMin;

			int value2 = 0;
			if (negMax != Integer.MIN_VALUE && negMin != 0)
				value2 = negMin / negMax;

			return Math.max(value1, value2);
		}
	}

	public static void main(String[] args) {
		System.out.println(new _152().new Solution().maxProduct(new int[] {
				2, 3, -2, 4
		}));
	}

}
