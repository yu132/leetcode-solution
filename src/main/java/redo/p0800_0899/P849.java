package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P849  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P849 {

    class Solution {
        public int maxDistToClosest(int[] seats) {
            int n = seats.length, low = 0, high = n - 1;
            while (seats[low] != 1) {
                ++low;
            }
            while (seats[high] != 1) {
                --high;
            }
            int max = Math.max(low, n - 1 - high), last = low;
            for (int i = low + 1; i <= high; ++i) {
                if (seats[i] == 1) {
                    max = Math.max(max, (i - last) / 2);
                    last = i;
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxDistToClosest(new int[] {1, 0, 0, 0, 1, 0, 1}));
        Assert.assertEquals(2, s.maxDistToClosest(new int[] {1, 0, 0, 0, 0, 1, 0, 1}));
        Assert.assertEquals(3, s.maxDistToClosest(new int[] {1, 0, 0, 0}));
        Assert.assertEquals(1, s.maxDistToClosest(new int[] {0, 1}));
    }

}
