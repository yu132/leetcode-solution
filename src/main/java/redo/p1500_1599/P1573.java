package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1573  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class P1573 {

    static//

    class Solution {

        private final static int MOD = 1000000007;

        public int numWays(String s) {
            int n = s.length();
            FixedIntArrayStack indexOf1 = new FixedIntArrayStack(s.length());
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '1') {
                    indexOf1.push(i);
                }
            }
            int numOf1 = indexOf1.index;
            if (numOf1 == 0) {
                return (int)((long)(n - 1) * (n - 2) / 2 % MOD);
            }
            if (numOf1 % 3 != 0) {
                return 0;
            }
            int part = numOf1 / 3;
            return (int)((long)(indexOf1.stack[part] - indexOf1.stack[part - 1])
                * (indexOf1.stack[2 * part] - indexOf1.stack[2 * part - 1]) % MOD);
        }

        static class FixedIntArrayStack {
            int index = 0, stack[];

            public FixedIntArrayStack(int len) {
                super();
                this.stack = new int[len];
            }

            public void push(int num) {
                stack[index++] = num;
            }

            public int pop() {
                return stack[--index];
            }

            public int peek() {
                return stack[index - 1];
            }

            public boolean isEmpty() {
                return index == 0;
            }

            public int size() {
                return index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.numWays("10101"));
        Assert.assertEquals(0, s.numWays("1001"));
        Assert.assertEquals(3, s.numWays("0000"));
        Assert.assertEquals(12, s.numWays("100100010100110"));
    }

}
