package _0_99;

public class _29 {

	public int divide(int dividend, int divisor) {

		if (dividend == divisor)
			return 1;

		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (dividend == Integer.MIN_VALUE && divisor == 1)
			return Integer.MIN_VALUE;

		if (divisor == -Integer.MIN_VALUE)
			return 0;

		boolean MIN = dividend == Integer.MIN_VALUE;

		boolean sign = (dividend < 0) ^ (divisor < 0);

		int dividend1 = MIN ? Integer.MAX_VALUE : Math.abs(dividend);
		int divisor1 = Math.abs(divisor);

		if (divisor1 == 1)
			return sign ? -dividend1 : dividend1;

		int[] num = new int[33];
		int[] times = new int[33];

		int x = 1;
		num[1] = divisor1;
		times[1] = 1;

		while (num[x] < dividend1 && num[x] >= 0) {
			num[x + 1] = num[x] + num[x];
			times[x + 1] = times[x] + times[x];
			++x;
		}

		if (num[x] < 0)
			--x;

		int count = 0;

		while (dividend1 >= divisor1) {
			if (num[x] <= dividend1) {
				dividend1 -= num[x];
				count += times[x];
			} else
				--x;
		}

		if (MIN) {
			++dividend1;
			if (dividend1 >= num[x])
				++count;
		}

		return sign ? -count : count;
	}

	public static void main(String[] args) {
		System.out.println(new _29().divide(-10000000, Integer.MIN_VALUE));
	}
}
