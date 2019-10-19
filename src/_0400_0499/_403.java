package _0400_0499;

public class _403 {

	//	class Solution {
	//		public boolean canCross(int[] stones) {
	//
	//			Map<Integer, Set<Integer>> map = new HashMap<>();
	//
	//			map.put(0, new HashSet<>(Arrays.asList(1)));
	//
	//			int max = 0;
	//
	//			for (int i = 0; i < stones.length; ++i) {
	//				Set<Integer> availableStep = map.get(stones[i]);
	//
	//				if (i > max && availableStep == null)
	//					return false;
	//
	//				if (availableStep == null)
	//					continue;
	//
	//				for (int step : availableStep) {
	//					if (step <= 0)
	//						continue;
	//					int nextStone = stones[i] + step;
	//					if (nextStone == stones[stones.length - 1])
	//						return true;
	//					if (Arrays.binarySearch(stones, i, stones.length, nextStone) >= 0) {
	//						max = Math.max(max, nextStone);
	//						Set<Integer> availableStepNextStone = map.getOrDefault(nextStone,
	//								new HashSet<>());
	//						availableStepNextStone.add(step - 1);
	//						availableStepNextStone.add(step);
	//						availableStepNextStone.add(step + 1);
	//						map.put(nextStone, availableStepNextStone);
	//					}
	//				}
	//			}
	//
	//			return false;
	//		}
	//	}

	/**
	 * 快，使用剪枝的方�?
	 */
	class Solution {
		int		n;
		boolean	vis[][];

		public boolean canCross(int[] stones) {
			n = stones.length;
			vis = new boolean[n][n];
			return go(stones, 0, 0);
		}

		boolean go(int a[], int pos, int k) {
			if (pos >= n)
				return false;
			if (pos == n - 1)
				return true;
			if (vis[pos][k])
				return false;
			for (int i = pos + 1; i < n; i++) {
				int gap = a[i] - a[pos];
				if (gap < k - 1)
					continue;
				if (gap > k + 1)
					break;
				if (go(a, i, gap))
					return true;
			}
			vis[pos][k] = true;
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(new _403().new Solution().canCross(new int[] {
				0, 2
		}));
	}

}
