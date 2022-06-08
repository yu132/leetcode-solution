package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P674  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P674 {

    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int inc = 1, max = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > nums[i - 1]) {
                    ++inc;
                } else {
                    max = Math.max(max, inc);
                    inc = 1;
                }
            }
            return Math.max(max, inc);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
        Assert.assertEquals(1, s.findLengthOfLCIS(new int[] {2, 2, 2, 2, 2}));
        Assert.assertEquals(8, s.findLengthOfLCIS(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
    }

}
