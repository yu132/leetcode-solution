package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1011  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1011 {

    static//

    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            return minSplit(weights, D);
        }

        public static int minSplit(int[] nums, int k) {
            int low = 0, high = sum(nums);
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(nums, mid, k)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        public static boolean check(int[] nums, int maxSum, int k) {
            int sum = 0, countSplit = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > maxSum) {
                    return false;
                }
                if (sum + nums[i] > maxSum) {
                    ++countSplit;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            ++countSplit;
            return countSplit <= k;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(15, s.shipWithinDays(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        Assert.assertEquals(6, s.shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3));
        Assert.assertEquals(3, s.shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
    }

}
