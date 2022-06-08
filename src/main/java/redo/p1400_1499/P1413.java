package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1413  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1413 {

    class Solution {
        public int minStartValue(int[] nums) {
            int min = Integer.MAX_VALUE, sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                min = Math.min(min, sum);
            }
            if (min > 0) {
                return 1;
            }
            return -min + 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.minStartValue(new int[] {-3, 2, -3, 4, 2}));
        Assert.assertEquals(1, s.minStartValue(new int[] {1, 2}));
        Assert.assertEquals(1, s.minStartValue(new int[] {5, 2, 4, 6}));
        Assert.assertEquals(5, s.minStartValue(new int[] {1, -2, -3}));
    }

}
