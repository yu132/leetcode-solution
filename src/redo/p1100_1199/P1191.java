package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1191  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1191 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        int start, end;

        public int kConcatenationMaxSum(int[] arr, int k) {

            start = end = 0;

            if (k == 1) {
                return kadane(arr);
            }
            int maxSubArrSum = kadane2(arr);

            int sum = sum(arr);

            if (sum <= 0) {// 贪心，如果数组总和大于0，那么加上总比不加好
                return maxSubArrSum;
            }

            return (int)((maxSubArrSum + (long)(k - 2) * sum) % MOD);
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        static int kadane(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int last, max;
            last = max = 0;
            for (int i = 0; i < nums.length; ++i) {
                max = Math.max(max, last = Math.max(last + nums[i], nums[i]));
            }
            return max;
        }

        int kadane2(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int last, max, start = 0;
            last = max = 0;
            for (int i = 0; i < nums.length * 2; ++i) {
                int index = i >= nums.length ? i - nums.length : i;
                if (last + nums[index] < nums[index]) {
                    start = i;
                    last = nums[index];
                } else {
                    last = last + nums[index];
                }

                if (max < last) {
                    max = last;
                    this.start = start;
                    this.end = i + 1;
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9, s.kConcatenationMaxSum(new int[] {1, 2}, 3));
        Assert.assertEquals(2, s.kConcatenationMaxSum(new int[] {1, -2, 1}, 5));
        Assert.assertEquals(0, s.kConcatenationMaxSum(new int[] {-1, -2}, 7));
        Assert.assertEquals(830336501, s.kConcatenationMaxSum(
            new int[] {1, 2, -1, -2, 100, 32, 412, -324, 312, 545, 978, 234, 9784, 123, 7866}, 91234));
        Assert.assertEquals(20, s.kConcatenationMaxSum(new int[] {-5, -2, 0, 0, 3, 9, -2, -5, 4}, 5));

        Assert.assertEquals(36,
            s.kConcatenationMaxSum(new int[] {-9, 13, 4, -16, -12, -16, 3, -7, 5, -16, 16, 8, -1, -13, 15, 3}, 6));
    }

}
