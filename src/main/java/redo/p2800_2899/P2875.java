package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.HashMap;
import java.util.Map;

public class P2875 {

    class Solution {
        public int minSizeSubarray(int[] nums, int target) {
            long sum = sumLong(nums);
            int baseMul = (int) (target / sum);
            target %= sum;
            long diff = sum - target;
            if (target == 0) {
                return baseMul * nums.length;
            }
            Map<Long, Integer> map = new HashMap<>();
            long sumNow = 0;
            int ans = Integer.MAX_VALUE;
            map.put(sumNow, -1);
            for (int i = 0; i < nums.length; ++i) {
                sumNow += nums[i];
                if (map.containsKey(sumNow - target)) {
                    ans = Math.min(ans, i - map.get(sumNow - target));
                }
                if (map.containsKey(sumNow - diff)) {
                    ans = Math.min(ans, nums.length - (i - map.get(sumNow - diff)));
                }
                map.put(sumNow, i);
            }
            if (ans == Integer.MAX_VALUE) {
                return -1;
            }
            return baseMul * nums.length + ans;
        }

        long sumLong(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P2875().new Solution().minSizeSubarray(Arrs.build("[2,1,5,7,7,1,6,3]"), 39));
    }

}
