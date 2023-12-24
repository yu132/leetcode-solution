package redo.p0800_0899;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P871 {

    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int nowDis = startFuel;
            PriorityQueue<Integer> backup = new PriorityQueue<>(Comparator.reverseOrder());
            int count = 0;
            int idx = 0;
            while (idx < stations.length && stations[idx][0] <= nowDis) {
                backup.offer(stations[idx][1]);
                ++idx;
            }
            while (nowDis < target && !backup.isEmpty()) {
                nowDis += backup.poll();
                ++count;
                while (idx < stations.length && stations[idx][0] <= nowDis) {
                    backup.offer(stations[idx][1]);
                    ++idx;
                }
            }
            if (nowDis >= target) {
                return count;
            }
            return -1;
        }
    }

}
