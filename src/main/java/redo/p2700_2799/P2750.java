package redo.p2700_2799;

import java.util.ArrayList;
import java.util.List;

public class P2750 {

    class Solution {
        public int numberOfGoodSubarraySplits(int[] nums) {
            List<Integer> counter = new ArrayList<>();
            int now = 0;
            for (int num : nums) {
                if (num == 0) {
                    ++now;
                } else {
                    counter.add(now);
                    now = 0;
                }
            }
            counter.add(now);
            if (counter.size() < 2) {
                return 0;
            }
            long ans = 1;
            for (int i = 1; i < counter.size() - 1; ++i) {
                if (counter.get(i) == 0) {
                    continue;
                }
                ans = multiply(ans, counter.get(i) + 1);
            }
            return (int) ans;
        }

        public final static int MOD = 1_000_000_007;

        int multiply(long a, long b) {
            return (int) (((a % MOD) * (b % MOD)) % MOD);
        }

    }

    public static void main(String[] args) {
        new P2750().new Solution().numberOfGoodSubarraySplits(new int[]{0, 1, 0, 0, 1});
    }

}
