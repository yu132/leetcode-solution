package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1680  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1680 {

    class Solution {

        public final static int MOD = 1000000007;

        public int concatenatedBinary(int n) {
            long num = 0;
            int shift = 0;
            for (int i = 1; i <= n; ++i) {
                if ((i & i - 1) == 0) {
                    ++shift;
                }
                num = (num << shift) + i;
                num %= MOD;
            }
            return (int)num;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.concatenatedBinary(1));
        Assert.assertEquals(27, s.concatenatedBinary(3));
        Assert.assertEquals(505379714, s.concatenatedBinary(12));
        Assert.assertEquals(678490511, s.concatenatedBinary(34552));
    }

}
