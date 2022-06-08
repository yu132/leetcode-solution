package redo.p1600_1699;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1695  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1695 {

    static//

    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            int[] prefix = prefix(nums);
            Map<Integer, Integer> lastShown = new HashMap<>();
            int sum = 0, start = 0, max = 0;
            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                sum += num;
                if (lastShown.containsKey(num)) {
                    int lastShownIndex = lastShown.get(num);
                    if (lastShownIndex >= start) {
                        sum -= prefix[lastShownIndex + 1] - prefix[start];
                        start = lastShownIndex + 1;
                    }
                }
                max = Math.max(max, sum);
                lastShown.put(num, i);
            }
            return max;
        }

        public static int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(17, s.maximumUniqueSubarray(new int[] {4, 2, 4, 5, 6}));
        Assert.assertEquals(8, s.maximumUniqueSubarray(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

}
