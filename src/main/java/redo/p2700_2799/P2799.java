package redo.p2700_2799;

import java.util.HashSet;
import java.util.Set;

public class P2799 {

    class Solution {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int x = set.size();
            set.clear();
            int[] counter = new int[2001];
            int ans = 0;
            for (int l = 0, r = 0; r < nums.length; ++r) {
                if (counter[nums[r]] == 0) {
                    set.add(nums[r]);
                }
                ++counter[nums[r]];
                if (set.size() == x) {
                    while (counter[nums[l]] > 1) {
                        --counter[nums[l]];
                        ++l;
                    }
                    ans += l + 1;
                }
            }
            return ans;
        }
    }

}
