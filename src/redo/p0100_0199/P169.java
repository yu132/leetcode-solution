package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P169  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P169 {

    class Solution {
        public int majorityElement(int[] nums) {
            int ans = 0, count = 0;
            for (int num : nums) {
                if (count == 0) {
                    ans = num;
                    count = 1;
                } else if (ans != num) {
                    --count;
                } else {
                    ++count;
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(3, s.majorityElement(new int[] {3, 2, 3}));
        assertEquals(2, s.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }
}
