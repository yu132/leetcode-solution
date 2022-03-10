package redo2012_05_29start;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P0001  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0001 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                if (map.containsKey(target - nums[i])) {
                    return new int[] {i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
            throw new RuntimeException();
        }
    }

}
