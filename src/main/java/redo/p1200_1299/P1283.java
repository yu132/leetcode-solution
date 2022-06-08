package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1283  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1283 {

    static//

    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int low = 1, high = max(nums) + 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (check(nums, mid, threshold)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }

        public boolean check(int[] nums, int divided, int threshold) {
            int sum = 0;
            for (int num : nums) {
                sum += (num - 1) / divided + 1;
            }
            return sum <= threshold;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.smallestDivisor(new int[] {1, 2, 5, 9}, 6));
        Assert.assertEquals(3, s.smallestDivisor(new int[] {2, 3, 5, 7, 11}, 11));
        Assert.assertEquals(4, s.smallestDivisor(new int[] {19}, 5));
    }

}
