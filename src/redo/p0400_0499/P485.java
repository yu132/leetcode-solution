package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P485  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P485 {

    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0, count = 0;
            for (int num : nums) {
                if (num == 0) {
                    max = Math.max(max, count);
                    count = 0;
                } else {
                    ++count;
                }
            }
            max = Math.max(max, count);
            return max;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
    }

}
