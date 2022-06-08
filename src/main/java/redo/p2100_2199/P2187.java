package redo.p2100_2199;

import java.util.Arrays;

public class P2187 {

    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            Arrays.sort(time);
            long min = 0, max = (long) time[0] * totalTrips;
            while (min < max) {
                long mid = (min + max) >>> 1;
                long times = 0;
                for (int t : time) {
                    times += mid / t;
                }
                if (times >= totalTrips) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }
    }

}
