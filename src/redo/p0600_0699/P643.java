package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P643  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P643 {

    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int window = 0;
            for (int i = 0; i < k; ++i) {
                window += nums[i];
            }
            double max = (double)window / k;
            for (int i = k, j = 0; i < nums.length; ++i, ++j) {
                window += nums[i] - nums[j];
                max = Math.max(max, (double)window / k);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12.75, s.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4), 0.0001);
        Assert.assertEquals(3.33333, s.findMaxAverage(new int[] {3, 3, 4, 3, 0}, 3), 0.0001);
    }

}
