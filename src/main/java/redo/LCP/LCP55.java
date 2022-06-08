package redo.LCP;

public class LCP55 {

    class Solution {
        public int getMinimumTime(int[] time, int[][] fruits, int limit) {

            int ans = 0;

            for (int[] fruit : fruits) {
                ans += ((fruit[1] - 1) / limit + 1) * time[fruit[0]];
            }

            return ans;
        }
    }

}
