package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1109  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1109 {

    static//

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            DifferentialArray diffArr = new DifferentialArray(n + 1);
            for (int[] booking : bookings) {
                diffArr.addRange(booking[2], booking[0], booking[1] + 1);
            }
            return diffArr.getNums();
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
                int[] nums = new int[differentialArray.length - 2];
                int sum = 0;
                for (int i = 1; i <= nums.length; ++i) {
                    sum += differentialArray[i];
                    nums[i - 1] = sum;
                }
                return nums;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {10, 55, 45, 25, 25},
            s.corpFlightBookings(Arrs.build2D("[[1,2,10],[2,3,20],[2,5,25]]"), 5));
    }

}
