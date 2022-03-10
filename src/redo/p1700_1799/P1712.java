package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1712  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1712 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int waysToSplit(int[] nums) {

            int n = nums.length;

            int[] prefix = prefix(nums);

            long ans = 0;

            for (int i = 1;
                i <= n && 2 * sumRange(prefix, 0, i) <= sumRange(prefix, i, n);
                ++i) {
                ans += Math.max(0, upperBound(prefix, i, n, i + 1, n)
                    - lowerBound(prefix, sumRange(prefix, 0, i), i, i + 1, n));
            }

            return (int)(ans % MOD);
        }

        int lowerBound(int[] prefix, int leftSum, int x, int ylow, int yhigh) {
            while (ylow < yhigh) {
                int mid = (ylow + yhigh) >>> 1;
                if (leftSum <= sumRange(prefix, x, mid)) {
                    yhigh = mid;
                } else {
                    ylow = mid + 1;
                }
            }
            return ylow;
        }

        int upperBound(int[] prefix, int x, int n, int ylow, int yhigh) {
            while (ylow < yhigh) {
                int mid = (ylow + yhigh) >>> 1;
                if (sumRange(prefix, x, mid) <= sumRange(prefix, mid, n)) {
                    ylow = mid + 1;
                } else {
                    yhigh = mid;
                }
            }
            return ylow;
        }

        int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        int sumRange(int[] prefix, int from, int to) {
            return prefix[to] - prefix[from];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.waysToSplit(new int[] {1, 1, 1}));
        Assert.assertEquals(3, s.waysToSplit(new int[] {1, 2, 2, 2, 5, 0}));
        Assert.assertEquals(0, s.waysToSplit(new int[] {3, 2, 1}));
    }
}
