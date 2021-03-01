package redo.p0500_0599;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P525  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P525 {

    class Solution {
        public int findMaxLength(int[] nums) {
            int preSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            int max = 0;
            for (int i = 0; i < nums.length; ++i) {
                preSum += nums[i] == 0 ? -1 : 1;
                if (map.containsKey(preSum)) {
                    max = Math.max(max, i - map.get(preSum));
                }
                map.putIfAbsent(preSum, i);
            }

            return max;
        }
    }

}
