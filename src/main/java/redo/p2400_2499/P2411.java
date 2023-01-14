package redo.p2400_2499;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class P2411 {

    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; --i) {
                int num = nums[i];
                while (num > 0) {
                    int lowbit = Integer.lowestOneBit(num);
                    map.put(lowbit, i);
                    num -= lowbit;
                }
                if (map.isEmpty()) {
                    ans[i] = 1;
                } else {
                    ans[i] = max(map.values()) - i + 1;
                }
            }
            return ans;
        }

        int max(Collection<Integer> collection) {
            int ans = Integer.MIN_VALUE;
            for (int num : collection) {
                ans = Math.max(num, ans);
            }
            return ans;
        }
    }

}
