package redo.p2500_2599;

import java.util.HashSet;
import java.util.Set;

public class P2568 {

    class Solution {
        public int minImpossibleOR(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 0; i <= 30; ++i) {
                if (!set.contains(1 << i)) {
                    return 1 << i;
                }
            }
            return 0;
        }
    }

}
