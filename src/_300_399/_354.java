package _300_399;

import java.util.Arrays;

public class _354 {

	/**
	 * 这个问题就是将二维的数组先把一维排好序
	 * 
	 * 然后选择另一维的一个最长上升子序列，这个序列的长度
	 * 即为我们能够嵌套的最大信封的数量
	 * 
	 * @author 87663
	 */
	class Solution {
		public int maxEnvelopes(int[][] envelopes) {

			if (envelopes.length == 0)
				return 0;

			Arrays.sort(envelopes, (a, b) -> {//长度小的信封在前面
				int ans1 = Integer.compare(a[0], b[0]);
				if (ans1 != 0)
					return ans1;
				else
					return Integer.compare(b[1], a[1]);//宽的信在前面，同样长的信只能选一封
			});

			//最长上升子序列
			int[] stack = new int[envelopes.length];
			int indexStack = 0;//最后一个元素所在的位置

			stack[0] = envelopes[0][1];

			for (int i = 1; i < envelopes.length; ++i) {
				if (envelopes[i][1] > stack[indexStack]) {//如果长度比栈顶的要大，将其放在栈顶
					stack[++indexStack] = envelopes[i][1];
				} else {//如果比栈顶的小，那么选择一个大于等于的位置进行覆盖，查找使用二分搜索
					int low = 0, high = indexStack;
					boolean flag = false;
					while (low <= high) {
						int mid = (low + high) >>> 1;
						if (envelopes[i][1] > stack[mid] && envelopes[i][1] <= stack[mid + 1]) {
							low = mid;
							flag = true;
							break;
						} else if (envelopes[i][1] > stack[mid])
							low = mid + 1;
						else
							high = mid - 1;
					}
					if (!flag)
						low = -1;
					stack[low + 1] = envelopes[i][1];
				}
			}

			return indexStack + 1;
		}
	}

}
