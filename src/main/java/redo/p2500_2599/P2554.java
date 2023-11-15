package redo.p2500_2599;

import java.util.HashSet;

public class P2554 {

    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            int ans = 0;
            long sum = 0;

            HashSet<Integer> set = new HashSet<>();
            for (int num : banned) {
                set.add(num);
            }

            for (int i = 1; i <= n; ++i) {
                if (set.contains(i)) {
                    continue;
                }
                sum += i;
                if (sum > maxSum) {
                    return ans;
                }
                ++ans;
            }

            return ans;
        }
    }

}
