package reredo.rrrd;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; ++i) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] {map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }

            throw new RuntimeException();
        }
    }

}
