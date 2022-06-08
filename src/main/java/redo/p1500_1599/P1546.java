package redo.p1500_1599;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1546  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1546 {

    class Solution {
        public int maxNonOverlapping(int[] nums, int target) {
            Set<Integer> partialPrefix = new HashSet<>();
            partialPrefix.add(0);

            int prefixSumNow = 0, count = 0;

            for (int num : nums) {
                prefixSumNow += num;
                if (partialPrefix.contains(prefixSumNow - target)) {
                    ++count;
                    partialPrefix.clear();
                    partialPrefix.add(0);
                    prefixSumNow = 0;
                } else {
                    partialPrefix.add(prefixSumNow);
                }
            }

            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxNonOverlapping(new int[] {1, 1, 1, 1, 1}, 2));
        Assert.assertEquals(2, s.maxNonOverlapping(new int[] {-1, 3, 5, 1, 4, 2, -9}, 6));

        Assert.assertEquals(3, s.maxNonOverlapping(new int[] {-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
        Assert.assertEquals(3, s.maxNonOverlapping(new int[] {0, 0, 0}, 0));

    }

}
