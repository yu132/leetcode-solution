package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P880  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P880 {

    static//

    class Solution {
        public String decodeAtIndex(String S, int K) {
            FixedIntArrayStack stackLen = new FixedIntArrayStack(S.length());
            FixedIntArrayStack stackTimes = new FixedIntArrayStack(S.length());

            char[] chs = S.toCharArray();

            long len = 0;

            for (int i = 0; i < chs.length; ++i) {
                if (Character.isDigit(chs[i])) {
                    stackLen.push(len);
                    stackTimes.push(chs[i] - '0');
                    len *= chs[i] - '0';
                    if (K < len) {
                        break;
                    }
                } else {
                    ++len;
                }
            }

            for (int i = stackLen.index - 1; i >= 0; --i) {
                // while (K > stackLen.stack[i] && stackTimes.stack[i] > 1) {
                // K -= stackLen.stack[i];
                // --stackTimes.stack[i];
                // }

                if (K > stackLen.stack[i] * (stackTimes.stack[i] - 1)) {
                    K -= stackLen.stack[i] * (stackTimes.stack[i] - 1);
                } else {
                    K %= stackLen.stack[i];
                    if (K == 0) {
                        K = (int)stackLen.stack[i];
                    }
                }
            }

            for (int i = 0; i < chs.length; ++i) {
                if (!Character.isDigit(chs[i])) {
                    --K;
                    if (K == 0) {
                        return String.valueOf(chs[i]);
                    }
                }
            }

            throw new RuntimeException("unreachable");
        }

        static class FixedIntArrayStack {
            int index = 0;
            long stack[];

            public FixedIntArrayStack(int len) {
                super();
                this.stack = new long[len];
            }

            public void push(long num) {
                stack[index++] = num;
            }

            public long pop() {
                return stack[--index];
            }

            public long peek() {
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
        Assert.assertEquals("o", s.decodeAtIndex("leet2code3", 10));
        Assert.assertEquals("h", s.decodeAtIndex("ha22", 5));
        Assert.assertEquals("a", s.decodeAtIndex("a2345678999999999999999", 1));
        Assert.assertEquals("a", s.decodeAtIndex("a2345678999999999999999", 10000));
        Assert.assertEquals("n", s.decodeAtIndex("ouino345no2i34n2o35no2n5n2o3i53n46n3p456n2", 64576934));
        Assert.assertEquals("c",
            s.decodeAtIndex(
                "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps",
                768077956));
    }

}
