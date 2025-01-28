package redo.p2800_2899;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2869 {

    class Solution {
        public int minOperations(List<Integer> nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = nums.size() - 1; i >= 0; --i) {
                if (nums.get(i) > k) {
                    continue;
                }
                set.add(nums.get(i));
                if (set.size() == k) {
                    return nums.size() - i;
                }
            }
            return 0;
        }
    }

}
