package reredo;

import java.util.HashMap;

/**  
 * @ClassName: P0001  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0001 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; ++i) {
                if (map.containsKey(target - nums[i])) {
                    if (map.get(target - nums[i]) != i) {
                        return new int[] {i, map.get(target - nums[i])};
                    }
                }
            }
            throw new RuntimeException("no anwser");
        }
    }

}
