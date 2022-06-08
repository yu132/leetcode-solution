package redo.contest.lccup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月5日  
 *  
 */
public class P01 {

    static//

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            long ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                ans += upperBound(nums, target - nums[i], 0, i);
            }
            return (int)(ans % MOD);
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
        Assert.assertEquals(1, s.purchasePlans(new int[] {2, 5, 3, 5}, 6));
        Assert.assertEquals(4, s.purchasePlans(new int[] {2, 2, 1, 9}, 10));

    }

}
