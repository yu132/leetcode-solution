package redo.p2000_2099;

import java.util.Arrays;

public class P2028 {

    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;

            int sum = (m + n) * mean;

            for (int num : rolls) {
                sum -= num;
            }

            if (n * 6 < sum || sum < n) {
                return new int[0];
            }

            int[] ans = new int[n];

            Arrays.fill(ans, 1);
            sum -= n;

            for (int i = 0; i < n && sum >= 0; ++i) {
                int temp = Math.min(sum, 5);
                ans[i] = 1 + temp;
                sum -= temp;
            }

            return ans;
        }
    }

}
