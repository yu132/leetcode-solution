package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;


/**  
 * @ClassName: P1399  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1399 {

    static//

    class Solution {
        public int countLargestGroup(int n) {
            int[] count = new int[37];
            for (int i = 1; i <= n; ++i) {
                ++count[digitsSum(i)];
            }
            int max = 0;
            for (int i = 0; i < 28; ++i) {
                max = Math.max(max, count[i]);
            }
            int ans = 0;
            for (int i = 0; i < 28; ++i) {
                if (count[i] == max) {
                    ++ans;
                }
            }
            return ans;
        }

        public static int digitsSum(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.countLargestGroup(13));
        Assert.assertEquals(2, s.countLargestGroup(2));
        Assert.assertEquals(6, s.countLargestGroup(15));
        Assert.assertEquals(5, s.countLargestGroup(24));
        Assert.assertEquals(6, s.countLargestGroup(46));
    }

}
