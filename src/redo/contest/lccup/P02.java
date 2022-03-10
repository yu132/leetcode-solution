package redo.contest.lccup;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月5日  
 *  
 */
public class P02 {

    // 4*num-4 -8
    class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            int l = yPos, r = num - 1 - yPos, u = xPos, d = num - 1 - xPos;
            int ring = Math.min(Math.min(l, r), Math.min(u, d));

            long first = 4 * (long)num - 4,
                last = first - (8 * ((long)ring - 1));

            long ans = (first + last) * ring / 2;

            if (u == ring) {
                ans += yPos - ring + 1;
                return (int)((ans - 1) % 9 + 1);
            }

            ans += num - 2 * ring - 1;

            if (r == ring) {
                ans += xPos - ring + 1;
                return (int)((ans - 1) % 9 + 1);
            }

            ans += num - 2 * ring - 1;

            if (d == ring) {
                ans += num - ring - yPos;
                return (int)((ans - 1) % 9 + 1);
            }

            ans += num - 2 * ring - 1;

            ans += num - ring - xPos;
            return (int)((ans - 1) % 9 + 1);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.orchestraLayout(3, 0, 2));
        Assert.assertEquals(5, s.orchestraLayout(4, 1, 2));
        Assert.assertEquals(7, s.orchestraLayout(5, 2, 2));
        Assert.assertEquals(9, s.orchestraLayout(5, 1, 2));
        Assert.assertEquals(1, s.orchestraLayout(5, 0, 0));
        Assert.assertEquals(5, s.orchestraLayout(5, 3, 1));
        Assert.assertEquals(2, s.orchestraLayout(5, 4, 2));
        Assert.assertEquals(7, s.orchestraLayout(5, 2, 4));
        Assert.assertEquals(5, s.orchestraLayout(5, 3, 0));
        Assert.assertEquals(7, s.orchestraLayout(4, 2, 1));
        Assert.assertEquals(1, s.orchestraLayout(1, 0, 0));
    }

}
