package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P747  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P747 {

    class Solution {
        public int dominantIndex(int[] nums) {
            int max = -1, max2 = -1, index = -1;
            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                if (num >= max) {
                    max2 = max;
                    max = num;
                    index = i;
                } else if (num > max2) {
                    max2 = num;
                }
            }
            return max >= 2 * max2 ? index : -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.dominantIndex(new int[] {3, 6, 1, 0}));
        Assert.assertEquals(-1, s.dominantIndex(new int[] {1, 2, 3, 4}));
    }
}
