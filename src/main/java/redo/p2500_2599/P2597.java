package redo.p2500_2599;

import java.util.HashSet;
import java.util.Set;

public class P2597 {

    class Solution {

        int ans = 0;

        public int beautifulSubsets(int[] nums, int k) {
            backtrack(0, k, nums, new HashSet<>());
            return ans - 1;
        }

        void backtrack(int index, int k, int[] nums, Set<Integer> set) {
            if (index == nums.length) {
                ++ans;
                return;
            }
            if (!set.contains(nums[index] - k) && !set.contains(nums[index] + k)) {
                boolean hasContain = set.contains(nums[index]);
                if (!hasContain) {
                    set.add(nums[index]);
                }
                backtrack(index + 1, k, nums, set);
                if (!hasContain) {
                    set.remove(nums[index]);
                }
            }
            backtrack(index + 1, k, nums, set);
        }

    }

}
