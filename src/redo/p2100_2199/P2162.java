package redo.p2100_2199;

public class P2162 {

    class Solution {
        public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            int min = targetSeconds / 60, sec = targetSeconds % 60;
            int _1 = min / 10, _2 = min % 10, _3 = sec / 10, _4 = sec % 10;
            int ans = helper(new int[]{_1, _2, _3, _4}, startAt, moveCost, pushCost);
            if (min == 100) {
                ans = Integer.MAX_VALUE;
            }
            if (sec <= 39 && min >= 0) {
                min -= 1;
                sec += 60;
                _1 = min / 10;
                _2 = min % 10;
                _3 = sec / 10;
                _4 = sec % 10;
                ans = Math.min(ans, helper(new int[]{_1, _2, _3, _4}, startAt, moveCost, pushCost));
            }
            return ans;
        }

        int helper(int[] postition, int startAt, int moveCost, int pushCost) {
            int now = startAt, cost = 0;
            boolean start0 = true;
            for (int i = 0; i < 4; ++i) {
                if (postition[i] == 0 && start0) {
                    continue;
                }
                start0 = false;
                if (postition[i] != now) {
                    cost += moveCost;
                    now = postition[i];
                }
                cost += pushCost;
            }
            return cost;
        }
    }

}
