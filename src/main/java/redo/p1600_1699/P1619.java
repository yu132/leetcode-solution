package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1619  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1619 {

    class Solution {
        public double trimMean(int[] arr) {
            Arrays.sort(arr);
            int p5 = (int)(arr.length * 0.05), sum = 0;
            for (int i = p5; i < arr.length - p5; ++i) {
                sum += arr[i];
            }
            return sum / (arr.length * 0.9);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2.0, s.trimMean(new int[] {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}),
            0.00001);
        Assert.assertEquals(4.0, s.trimMean(new int[] {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0}),
            0.00001);
        Assert.assertEquals(4.77778, s.trimMean(new int[] {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4,
            8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4}), 0.00001);
        Assert.assertEquals(5.27778,
            s.trimMean(new int[] {9, 7, 8, 7, 7, 8, 4, 4, 6, 8, 8, 7, 6, 8, 8, 9, 2, 6, 0, 0, 1, 10, 8, 6, 3, 3, 5, 1,
                10, 9, 0, 7, 10, 0, 10, 4, 1, 10, 6, 9, 3, 6, 0, 0, 2, 7, 0, 6, 7, 2, 9, 7, 7, 3, 0, 1, 6, 1, 10, 3}),
            0.00001);
        Assert.assertEquals(5.29167,
            s.trimMean(new int[] {4, 8, 4, 10, 0, 7, 1, 3, 7, 8, 8, 3, 4, 1, 6, 2, 1, 1, 8, 0, 9, 8, 0, 3, 9, 10, 3, 10,
                1, 10, 7, 3, 2, 1, 4, 9, 10, 7, 6, 4, 0, 8, 5, 1, 2, 1, 6, 2, 5, 0, 7, 10, 9, 10, 3, 7, 10, 5, 8, 5, 7,
                6, 7, 6, 10, 9, 5, 10, 5, 5, 7, 2, 10, 7, 7, 8, 2, 0, 1, 1}),
            0.00001);
    }

}
