package redo.p0500_0599;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P502 {

    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int n = profits.length;
            Integer[] idx = new Integer[n];
            Arrays.setAll(idx, x -> x);
            Arrays.sort(idx, Comparator.comparingInt(a -> capital[a]));
            int nowIdx = 0;
            while (k > 0) {
                while (nowIdx < n && capital[idx[nowIdx]] <= w) {
                    pq.offer(profits[idx[nowIdx]]);
                    ++nowIdx;
                }
                if (pq.isEmpty()) {
                    break;
                }
                w += pq.poll();
                --k;
            }
            return w;
        }
    }

}
