package redo.p0500_0599;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P523  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P523 {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {

            int preSum = 0;

            Map<Integer, Integer> map = new HashMap<>();

            map.put(0, -1);

            for (int i = 0; i < nums.length; ++i) {

                preSum += nums[i];

                if (k != 0) {
                    preSum %= k;
                }

                if (map.containsKey(preSum)) {
                    if (i - map.get(preSum) > 1) {
                        return true;
                    }
                } else {
                    map.put(preSum, i);
                }
            }

            return false;
        }
    }

}
