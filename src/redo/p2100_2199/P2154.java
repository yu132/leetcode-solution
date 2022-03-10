package redo.p2100_2199;

import java.util.HashSet;
import java.util.Set;

public class P2154 {

    class Solution {
        public int findFinalValue(int[] nums, int original) {
            Set<Integer> set = toSet(nums);

            while (set.contains(original)) {
                original *= 2;
            }

            return original;
        }

        Set<Integer> toSet(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set;
        }
    }

}
