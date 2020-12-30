package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**  
 * @ClassName: P217  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P217 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(true, s.containsDuplicate(new int[] {1, 2, 3, 1}));
        assertEquals(false, s.containsDuplicate(new int[] {1, 2, 3, 4}));
        assertEquals(true, s.containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

}
