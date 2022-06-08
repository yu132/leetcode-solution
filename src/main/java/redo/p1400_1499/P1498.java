package redo.p1400_1499;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1498  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1498 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        public int numSubseq(int[] nums, int target) {
            Arrays.sort(nums);

            long ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > target || target - nums[i] < nums[i]) {
                    break;
                }
                int index = upperBound(nums, target - nums[i], 0, nums.length);
                if (nums[i] + nums[index - 1] <= target) {
                    ans = (ans + myPow(2, index - i - 1, MOD)) % MOD;
                }
            }

            return (int)ans;
        }

        public int myPow(int X, int n, int mod) {
            long num = 1, x = X;
            while (n > 0) {
                if (n % 2 == 1) {
                    num = (num * x) % mod;
                }
                n >>= 1;
                x = (x * x) % mod;
            }
            return (int)num;
        }

        public int upperBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numSubseq(new int[] {3, 5, 6, 7}, 9));
        Assert.assertEquals(6, s.numSubseq(new int[] {3, 3, 6, 8}, 10));
        Assert.assertEquals(61, s.numSubseq(new int[] {2, 3, 3, 4, 6, 7}, 12));
        Assert.assertEquals(127, s.numSubseq(new int[] {5, 2, 4, 1, 7, 6, 8}, 16));
        Assert.assertEquals(272187084,
            s.numSubseq(new int[] {14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11,
                10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
    }
}
