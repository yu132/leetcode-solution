package redo.p1500_1599;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1590  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1590 {

    static//

    class Solution {
        public int minSubarray(int[] nums, int p) {
            long sum = sum(nums);

            Map<Integer, Integer> prefix = new HashMap<>();

            prefix.put(0, -1);

            if (sum < p) {
                return -1;
            }

            int diff = (int)(sum % p);

            if (diff == 0) {
                return 0;
            }

            long prefixNow = 0;

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; ++i) {
                prefixNow += nums[i];
                int mod = (int)(prefixNow % p);
                int aim = (mod - diff + p) % p;
                if (prefix.containsKey(aim)) {
                    min = Math.min(min, i - prefix.get(aim));
                }
                prefix.put(mod, i);
            }

            return min >= nums.length ? -1 : min;
        }

        public static long sum(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(1, s.minSubarray(new int[] {3, 1, 4, 2}, 6));
        // Assert.assertEquals(2, s.minSubarray(new int[] {6, 3, 5, 2}, 9));
        // Assert.assertEquals(0, s.minSubarray(new int[] {1, 2, 3}, 3));
        // Assert.assertEquals(-1, s.minSubarray(new int[] {1, 2, 3}, 7));
        Assert.assertEquals(-1, s.minSubarray(new int[] {4, 4, 2}, 7));
        Assert.assertEquals(0, s.minSubarray(new int[] {1000000000, 1000000000, 1000000000}, 3));
        Assert.assertEquals(1, s.minSubarray(new int[] {1000000000, 1000000000, 1000000000, 1000000000}, 3));

    }

}
