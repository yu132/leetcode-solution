package redo.p1500_1599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1509  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1509 {

    class Solution {
        public int minDifference(int[] nums) {
            if (nums.length <= 4) {
                return 0;
            }

            if (nums.length < 30) {
                Arrays.sort(nums);
                int min = Integer.MAX_VALUE;
                for (int low = 0, high = nums.length - 4; high < nums.length; ++low, ++high) {
                    min = Math.min(min, nums[high] - nums[low]);
                }
                return min;
            }

            int[][] maxMin4 = maxMinN(nums, 4);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= 3; ++i) {
                min = Math.min(min, maxMin4[1][i] - maxMin4[0][3 - i]);
            }
            return min;
        }

        // [0] min -3,-2,-1 小到大
        // [1] max 3,2,1 大到小
        public int[][] maxMinN(int[] arr, int k) {
            int[] max = new int[k], min = new int[k];
            Arrays.fill(max, Integer.MIN_VALUE);
            Arrays.fill(min, Integer.MAX_VALUE);
            for (int num : arr) {
                for (int i = 0; i < max.length; ++i) {
                    if (num >= max[i]) {
                        System.arraycopy(max, i, max, i + 1, max.length - i - 1);
                        max[i] = num;
                        break;
                    }
                }
                for (int i = 0; i < min.length; ++i) {
                    if (num <= min[i]) {
                        System.arraycopy(min, i, min, i + 1, min.length - i - 1);
                        min[i] = num;
                        break;
                    }
                }
            }
            return new int[][] {min, max};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(0, s.minDifference(new int[] {5, 3, 2, 4}));
        Assert.assertEquals(1, s.minDifference(new int[] {1, 5, 0, 10, 14}));
        Assert.assertEquals(2, s.minDifference(new int[] {6, 6, 0, 1, 1, 4, 6}));
        Assert.assertEquals(1, s.minDifference(new int[] {1, 5, 6, 14, 15}));
        Assert.assertEquals(17, s.minDifference(new int[] {9, 48, 92, 48, 81, 31}));
    }

}
