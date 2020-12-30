package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P219  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P219 {

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; ++i) {
                if (i - map.getOrDefault(nums[i], -1000000) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }

            return false;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(true, s.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
        assertEquals(true, s.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        assertEquals(false, s.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }

}
