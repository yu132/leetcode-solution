package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月16日  
 *  
 */
public class P01 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);

            for (int i = 0; i < nums.length; ++i) {
                if (map.containsKey(nums[i])) {
                    return new int[] {map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);
            }

            throw new RuntimeException();
        }
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {0, 1}, new Solution().twoSum(new int[] {2, 7, 11, 15}, 9));
    }

}
