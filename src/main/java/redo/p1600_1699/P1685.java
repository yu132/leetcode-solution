package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1685  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1685 {

    class Solution {
        public int[] getSumAbsoluteDifferences(int[] nums) {
            int diffSumRight = 0, diffSumLeft = 0;
            for (int i = 1; i < nums.length; ++i) {
                diffSumRight += nums[i] - nums[0];
            }
            int[] ans = new int[nums.length];
            ans[0] = diffSumRight;
            for (int i = 1; i < nums.length; ++i) {
                diffSumRight -= (nums.length - i) * (nums[i] - nums[i - 1]);
                diffSumLeft += i * (nums[i] - nums[i - 1]);
                ans[i] = diffSumLeft + diffSumRight;
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {4, 3, 5}, s.getSumAbsoluteDifferences(new int[] {2, 3, 5}));
        Assert.assertArrayEquals(new int[] {24, 15, 13, 15, 21},
            s.getSumAbsoluteDifferences(new int[] {1, 4, 6, 8, 10}));
        Assert.assertArrayEquals(
            new int[] {69225387, 69221490, 69184236, 69091396, 69058999, 69040909, 69074239, 71214223, 73371023,
                73371751, 654107839},
            s.getSumAbsoluteDifferences(
                new int[] {1, 434, 5756, 24324, 35123, 53213, 86543, 799871, 1231231, 1231335, 65757567}));
    }

}
