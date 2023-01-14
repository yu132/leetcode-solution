package redo.p2400_2499;

public class P2432 {

    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int start = 0;
            int maxTime = 0, maxId = -1;

            for (int[] log : logs) {
                int time = log[1] - start;
                if (time > maxTime) {
                    maxTime = time;
                    maxId = log[0];
                } else if (time == maxTime && log[0] < maxId) {
                    maxId = log[0];
                }
                start = log[1];
            }

            return maxId;
        }
    }

}
