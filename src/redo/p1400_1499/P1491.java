package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1491  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1491 {

    class Solution {
        public double average(int[] salary) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
            for (int num : salary) {
                max = Math.max(max, num);
                min = Math.min(min, num);
                sum += num;
            }
            return (sum - max - min) / (double)(salary.length - 2);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2500d, s.average(new int[] {4000, 3000, 1000, 2000}), 0.00001);
        Assert.assertEquals(2000d, s.average(new int[] {1000, 2000, 3000}), 0.00001);
        Assert.assertEquals(3500d, s.average(new int[] {6000, 5000, 4000, 3000, 2000, 1000}), 0.00001);
        Assert.assertEquals(4750d, s.average(new int[] {8000, 9000, 2000, 3000, 6000, 1000}), 0.00001);
    }

}
