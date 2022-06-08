package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1482  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1482 {

    static//

    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if (m * k > bloomDay.length) {
                return -1;
            }
            int[] temp = minMax(bloomDay);
            int low = temp[0], high = temp[1];
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (isPossible(bloomDay, mid, m, k)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public boolean isPossible(int[] bloomDay, int day, int m, int k) {
            int num = 0, count = 0;
            for (int i = 0; i < bloomDay.length; ++i) {
                if (bloomDay[i] <= day) {
                    ++num;
                    if (num >= k) {
                        ++count;
                        if (count >= m) {
                            return true;
                        }
                        num = 0;
                    }
                } else {
                    num = 0;
                }
            }
            return false;
        }

        public static int[] minMax(int[] nums) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            return new int[] {min, max};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minDays(new int[] {1, 10, 3, 10, 2}, 3, 1));
        Assert.assertEquals(-1, s.minDays(new int[] {1, 10, 3, 10, 2}, 3, 2));
        Assert.assertEquals(12, s.minDays(new int[] {7, 7, 7, 7, 12, 7, 7}, 2, 3));
        Assert.assertEquals(1000000000, s.minDays(new int[] {1000000000, 1000000000}, 1, 1));
        Assert.assertEquals(9, s.minDays(new int[] {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }

}
