package redo.p2900_2999;

public class P2960 {

    class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int ans = 0;
            for (int i = 0; i < batteryPercentages.length; ++i) {
                if (batteryPercentages[i] > ans) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
