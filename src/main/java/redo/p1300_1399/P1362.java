package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1362  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1362 {

    class Solution {
        public int[] closestDivisors(int num) {
            int[] ans1 = factor(num + 1);
            int[] ans2 = factor(num + 2);
            if (ans1[1] - ans1[0] < ans2[1] - ans2[0]) {
                return ans1;
            } else {
                return ans2;
            }
        }

        public int[] factor(int num) {
            for (int i = (int)Math.sqrt(num); i >= 1; --i) {
                if (num % i == 0) {
                    return new int[] {i, num / i};
                }
            }
            throw new RuntimeException("unreachable");
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 3}, s.closestDivisors(8));
        Assert.assertArrayEquals(new int[] {5, 25}, s.closestDivisors(123));
        Assert.assertArrayEquals(new int[] {25, 40}, s.closestDivisors(999));
        Assert.assertArrayEquals(new int[] {22471, 23349}, s.closestDivisors(524675377));
    }

}
