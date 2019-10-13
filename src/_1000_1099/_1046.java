package _1000_1099;

import java.util.PriorityQueue;

public class _1046 {
	
	class Solution {
		public int lastStoneWeight(int[] stones) {
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
			
			for (int each : stones) {
				pq.add(each);
			}
			
			while (pq.size() > 1) {
				int	h1	= pq.poll();
				int	h2	= pq.poll();
				if (h1 - h2 == 0) {
					continue;
				}
				pq.offer(Math.abs(h1 - h2));
			}
			
			return pq.isEmpty() ? 0 : pq.poll();
		}
	}
	
}
