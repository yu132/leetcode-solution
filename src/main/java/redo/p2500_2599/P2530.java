package redo.p2500_2599;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P2530 {

    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                pq.offer(num);
            }
            long ans = 0;
            for (int i = 0; i < k; ++i) {
                int val = pq.poll();
                ans += val;
                pq.offer((val - 1) / 3 + 1);
            }
            return ans;
        }
    }

}
