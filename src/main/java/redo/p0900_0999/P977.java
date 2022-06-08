package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P977  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P977 {

    class Solution {
        public int[] sortedSquares(int[] nums) {
            int mid = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (Math.abs(nums[i - 1]) >= Math.abs(nums[i])) {
                    ++mid;
                } else {
                    break;
                }
            }
            int low = mid, high = mid + 1, index = 0;
            int[] ans = new int[nums.length];
            while (low >= 0 && high < nums.length) {
                if (Math.abs(nums[low]) <= Math.abs(nums[high])) {
                    ans[index++] = nums[low] * nums[low];
                    --low;
                } else {
                    ans[index++] = nums[high] * nums[high];
                    ++high;
                }
            }
            while (low >= 0) {
                ans[index++] = nums[low] * nums[low];
                --low;
            }
            while (high < nums.length) {
                ans[index++] = nums[high] * nums[high];
                ++high;
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 1, 9, 16, 100}, s.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
        Assert.assertArrayEquals(new int[] {4, 9, 9, 49, 121}, s.sortedSquares(new int[] {-7, -3, 2, 3, 11}));
        Assert.assertArrayEquals(new int[] {1, 4, 4, 4, 9, 9, 9, 16, 64, 100},
            s.sortedSquares(new int[] {-10, -3, -2, -2, -2, 1, 3, 3, 4, 8}));
    }

}
