package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1017  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1017 {

    class Solution {
        public String baseNeg2(int N) {

            if (N == 0) {
                return "0";
            }

            StringBuilder buf = new StringBuilder(40);
            int inc = 0;
            while (N != 0) {
                int sum = inc + N % -2;
                if (sum == -2) {
                    inc = 1;
                    buf.append(0);
                } else if (sum == -1) {
                    inc = 1;
                    buf.append(1);
                } else if (sum == 0 || sum == 1) {
                    inc = 0;
                    buf.append(sum);
                } else {// sum == 2
                    inc = -1;
                    buf.append(0);
                }
                N /= -2;
            }
            if (inc == 1) {
                buf.append(1);
            } else if (inc == -1) {
                buf.append(1);
                buf.append(1);
            }
            return buf.reverse().toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("110", s.baseNeg2(2));
        Assert.assertEquals("111", s.baseNeg2(3));
        Assert.assertEquals("100", s.baseNeg2(4));
        Assert.assertEquals("0", s.baseNeg2(0));
    }

}
