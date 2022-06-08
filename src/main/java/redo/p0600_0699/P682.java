package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P682  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P682 {

    class Solution {
        public int calPoints(String[] ops) {
            int[] stack = new int[ops.length];
            int len = 0;
            for (String str : ops) {
                switch (str) {
                    case "C":
                        --len;
                        break;
                    case "D":
                        stack[len] = stack[len - 1] * 2;
                        ++len;
                        break;
                    case "+":
                        stack[len] = stack[len - 2] + stack[len - 1];
                        ++len;
                        break;
                    default:
                        stack[len] = Integer.valueOf(str);
                        ++len;
                        break;
                }
            }
            int sum = 0;
            for (int i = 0; i < len; ++i) {
                sum += stack[i];
            }
            return sum;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(30, s.calPoints(new String[] {"5", "2", "C", "D", "+"}));
        Assert.assertEquals(27, s.calPoints(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

}
