package redo.p0200_0299;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P274  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P274 {

    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] count = new int[n + 1];
            for (int h : citations) {
                ++count[Math.min(n, h)];
            }

            int k = n;

            for (int s = count[n]; k > s; s += count[k]) {
                --k;
            }

            return k;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.hIndex(new int[] {3, 0, 6, 1, 5}));
        Assert.assertEquals(1, s.hIndex(new int[] {100}));
    }

}
