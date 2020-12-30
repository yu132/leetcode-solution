package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1480  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1480 {

    class Solution {
        public int[] runningSum(int[] nums) {
            int last = 0;
            for (int i = 0; i < nums.length; ++i) {
                nums[i] += last;
                last = nums[i];
            }
            return nums;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 3, 6, 10}, s.runningSum(new int[] {1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, s.runningSum(new int[] {1, 1, 1, 1, 1}));
        Assert.assertArrayEquals(new int[] {3, 4, 6, 16, 17}, s.runningSum(new int[] {3, 1, 2, 10, 1}));
    }

}
