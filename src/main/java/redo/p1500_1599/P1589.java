package redo.p1500_1599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1589  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1589 {

    static //

    class Solution {
        public int maxSumRangeQuery(int[] nums, int[][] requests) {
            DifferentialArray array = new DifferentialArray(nums.length);
            for (int[] request : requests) {
                array.addRange(1, request[0], request[1] + 1);
            }
            int[] counts = array.getNums();
            Arrays.sort(counts);
            Arrays.sort(nums);
            long ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                ans = (ans + (long)counts[i] * nums[i]) % 1000000007;
            }
            return (int)ans;
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

            public int[] getNums() {
                int[] nums = new int[differentialArray.length - 1];
                int sum = 0;
                for (int i = 0; i < nums.length; ++i) {
                    sum += differentialArray[i];
                    nums[i] = sum;
                }
                return nums;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(19, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5}, Arrs.build2D("[[1,3],[0,1]]")));
        // Assert.assertEquals(11, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 6}, Arrs.build2D("[[0,1]]")));
        // Assert.assertEquals(47, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 10},
        // Arrs.build2D("[[0,2],[1,3],[1,1]]")));
        Assert.assertEquals(999999986, s.maxSumRangeQuery(new int[] {1000000000}, Arrs.build2D("[[0,0],[0,0],[0,0]]")));
    }

}
