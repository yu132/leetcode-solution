package redo.p1400_1499;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1465  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1465 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int hMax = getMaxDiff(horizontalCuts, h), wMax = getMaxDiff(verticalCuts, w);
            return (int)(((long)hMax * wMax) % MOD);
        }

        private int getMaxDiff(int[] arr, int n) {
            int max = 0, last = 0;
            Arrays.sort(arr);
            for (int num : arr) {
                max = Math.max(max, num - last);
                last = num;
            }
            max = Math.max(max, n - last);

            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxArea(5, 4, new int[] {1, 2, 4}, new int[] {1, 3}));

        Assert.assertEquals(6, s.maxArea(5, 4, new int[] {3, 1}, new int[] {1}));

        Assert.assertEquals(9, s.maxArea(5, 4, new int[] {3}, new int[] {3}));

        Assert.assertEquals(979300008, s.maxArea(10000000, 10000000, new int[] {1}, new int[] {1}));

    }

}
