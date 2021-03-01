package redo.p0500_0599;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P560  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P560 {

    class Solution {
        public int subarraySum(int[] nums, int k) {

            int preSum = 0, ans = 0;

            Map<Integer, Integer> counters = new HashMap<>();

            plus1(counters, 0);

            for (int num : nums) {
                preSum += num;
                ans += counters.getOrDefault(preSum - k, 0);
                plus1(counters, preSum);
            }

            return ans;
        }

        void plus1(Map<Integer, Integer> counters, int val) {
            counters.put(val, counters.getOrDefault(val, 0) + 1);
        }
    }

}
