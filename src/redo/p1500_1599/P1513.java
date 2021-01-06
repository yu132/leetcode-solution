package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1513  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1513 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        public int numSub(String s) {
            long count = 0, len = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') {
                    ++len;
                } else {
                    count = (count + getSum(len)) % MOD;
                    len = 0;
                }
            }
            count = (count + getSum(len)) % MOD;
            return (int)count;
        }

        public long getSum(long n) {
            return n * (n + 1) / 2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(9, s.numSub("0110111"));
        Assert.assertEquals(2, s.numSub("101"));
        Assert.assertEquals(21, s.numSub("111111"));
        Assert.assertEquals(0, s.numSub("000"));
    }

}
