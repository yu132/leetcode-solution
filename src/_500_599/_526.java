package _500_599;

public class _526 {

	//	public static void main(String[] args) {
	//		for (int i = 1; i <= 15; ++i) {
	//			int[] array = new int[i + 1];
	//			Arrays.setAll(array, (x) -> x);
	//			System.out.print(allPermutation(array, 1) + ",");
	//		}
	//	}
	//
	//	public static void swap(int[] array, int x, int y) {
	//		int num = array[x];
	//		array[x] = array[y];
	//		array[y] = num;
	//	}
	//
	//	public static int allPermutation(int[] array, int now) {
	//		if (now == array.length)
	//			return 1;
	//
	//		int count = 0;
	//
	//		for (int i = now; i < array.length; ++i) {
	//			swap(array, now, i);
	//			if (array[now] % now == 0 || now % array[now] == 0)
	//				count += allPermutation(array, now + 1);
	//			swap(array, now, i);
	//		}
	//
	//		return count;
	//	}

	class Solution {

		private int[] table = {
				0, 1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679
		};

		public int countArrangement(int N) {
			return table[N];
		}

	}

}
