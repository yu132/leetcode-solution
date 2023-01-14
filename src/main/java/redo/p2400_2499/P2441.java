package redo.p2400_2499;

import java.util.HashSet;
import java.util.Set;

public class P2441 {

    class Solution {
        public int findMaxK(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int max = -1;
            for (int num : nums) {
                if (set.contains(-num)) {
                    max = Math.max(max, Math.abs(num));
                } else {
                    set.add(num);
                }
            }
            return max;
        }
    }

}
