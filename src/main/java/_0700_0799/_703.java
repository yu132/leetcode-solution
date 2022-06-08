package _0700_0799;

import java.util.PriorityQueue;

public class _703 {
	
	class KthLargest {
		
		private PriorityQueue<Integer> pq;
		
		public KthLargest(int k, int[] nums) {
			
			pq = new PriorityQueue<Integer>(k,
					(n1, n2) -> Integer.compare(n1, n2));
			
			for (int i = 0; i < k - 1; ++i) {
				pq.add(nums[i]);
			}
			
			if (nums.length == k - 1) {
				pq.add(Integer.MIN_VALUE);
			} else {
				pq.add(nums[k - 1]);
			}
			
			for (int i = k; i < nums.length; ++i) {
				int top = pq.peek();
				if (nums[i] > top) {
					pq.poll();
					pq.add(nums[i]);
				}
			}
		}
		
		public int add(int val) {
			int top = pq.peek();
			if (val > top) {
				pq.poll();
				pq.add(val);
			}
			return pq.peek();
		}
	}
	
	public static void main(String[] args) {
		new _703().new KthLargest(1, new int[0]);
	}
	
}
