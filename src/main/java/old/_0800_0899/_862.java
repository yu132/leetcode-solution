package old._0800_0899;

import java.util.Deque;
import java.util.LinkedList;

public class _862 {

	class Solution {
		public int shortestSubarray(int[] A, int K) {

			if (A.length == 0)
				return -1;

			int[] preSum = new int[A.length + 1];

			preSum[0] = 0;

			for (int i = 0; i < A.length; ++i)
				preSum[i + 1] = preSum[i] + A[i];

			int minLength = Integer.MAX_VALUE;

			Deque<Integer> deque = new LinkedList<>();

			for (int i = 0; i < A.length + 1; ++i) {
				while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()])
					deque.removeLast();
				while (!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K)
					minLength = Math.min(minLength, i - deque.removeFirst());
				deque.addLast(i);
			}

			return minLength == Integer.MAX_VALUE ? -1 : minLength;
		}
	}

}
