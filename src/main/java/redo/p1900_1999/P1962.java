package redo.p1900_1999;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1962 {

    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(piles.length,
                    Comparator.reverseOrder());

            for (int pile : piles) {
                pq.offer(pile);
            }

            for (int i = 0; i < k; ++i) {
                int val = pq.poll();
                pq.offer((val + 1) / 2);
            }

            int ans = 0;
            while (!pq.isEmpty()) {
                ans += pq.poll();
            }

            return ans;
        }
    }

}
