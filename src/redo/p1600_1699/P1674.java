package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1674  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1674 {

    static//

    class Solution {
        public int minMoves(int[] nums, int limit) {

            DifferentialArray dArr = new DifferentialArray(2 * limit + 1);

            for (int i = 0; i < nums.length / 2; ++i) {
                int n = nums[i], m = nums[nums.length - 1 - i];
                dArr.addIncludeRange(2, 2, 2 * limit);
                dArr.addIncludeRange(-1, 1 + Math.min(n, m), limit + Math.max(n, m));
                dArr.addIncludeRange(-1, n + m, n + m);
            }
            int sum = 0, min = Integer.MAX_VALUE;
            for (int i = 2; i <= 2 * limit; ++i) {
                sum += dArr.differentialArray[i];
                min = Math.min(min, sum);
            }
            return min;
        }

        static class DifferentialArray {

            int[] differentialArray;

            public DifferentialArray(int[] nums) {
                differentialArray = new int[nums.length + 1];
                for (int i = 1; i < nums.length; ++i) {
                    differentialArray[i] = nums[i] - nums[i - 1];
                }
            }

            public DifferentialArray(int len) {
                differentialArray = new int[len + 1];
            }

            // to是不包括的
            public void addRange(int value, int start, int to) {
                differentialArray[start] += value;
                differentialArray[to] -= value;
            }

            // to是包括的
            public void addIncludeRange(int value, int start, int to) {
                differentialArray[start] += value;
                differentialArray[to + 1] -= value;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minMoves(new int[] {1, 2, 4, 3}, 4));
        Assert.assertEquals(2, s.minMoves(new int[] {1, 2, 2, 1}, 2));
        Assert.assertEquals(0, s.minMoves(new int[] {1, 2, 1, 2}, 2));
    }

}
