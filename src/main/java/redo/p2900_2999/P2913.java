package redo.p2900_2999;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2913 {

    class Solution {
        int MOD = 1_000_000_007;

        public int sumCounts(List<Integer> nums) {
            long ans = 0;
            for (int i = 0; i < nums.size(); ++i) {
                for (int j = i; j < nums.size(); ++j) {
                    Set<Integer> set = new HashSet<>();
                    for (int k = i; k <= j; ++k) {
                        set.add(nums.get(k));
                    }
                    ans += ((long) set.size() * set.size()) % MOD;
                }
            }
            return (int) ans;
        }
    }

}
