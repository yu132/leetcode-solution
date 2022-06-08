package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P914  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月24日  
 *  
 */
public class P914 {

    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] count = new int[10000];

            for (int num : deck) {
                ++count[num];
            }

            int gcd = -1;

            for (int num : count) {
                if (num == 0) {
                    continue;
                } else if (num == 1) {
                    return false;
                } else {
                    if (gcd == -1) {
                        gcd = num;
                    } else {
                        gcd = gcd(gcd, num);
                    }
                }
            }

            return gcd != 1;
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.hasGroupsSizeX(new int[] {1, 2, 3, 4, 4, 3, 2, 1}));
        Assert.assertEquals(false, s.hasGroupsSizeX(new int[] {1, 1, 1, 2, 2, 2, 3, 3}));
        Assert.assertEquals(false, s.hasGroupsSizeX(new int[] {1}));
        Assert.assertEquals(true, s.hasGroupsSizeX(new int[] {1, 1}));
        Assert.assertEquals(true, s.hasGroupsSizeX(new int[] {1, 1, 2, 2, 2, 2}));
    }

}
