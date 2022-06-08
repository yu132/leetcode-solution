package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1209  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1209 {

    static//

    class Solution {
        public String removeDuplicates(String s, int k) {
            FixedCharArrayStack stack = new FixedCharArrayStack(s.length());

            for (char ch : s.toCharArray()) {
                stack.push(ch);
                if (stack.peekLen() == k) {
                    for (int i = 0; i < k; ++i) {
                        stack.pop();
                    }
                }
            }

            return String.copyValueOf(stack.stack, 0, stack.index);
        }

        static class FixedCharArrayStack {
            int index = 0;
            char[] stack;
            int[] sameLen;

            public FixedCharArrayStack(int len) {
                super();
                this.stack = new char[len];
                sameLen = new int[len];
            }

            public void push(char num) {
                if (index == 0 || stack[index - 1] != num) {
                    sameLen[index] = 1;
                } else {
                    sameLen[index] = sameLen[index - 1] + 1;
                }
                stack[index++] = num;
            }

            public char pop() {
                return stack[--index];
            }

            public char peek() {
                return stack[index - 1];
            }

            public int peekLen() {
                return sameLen[index - 1];
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
        Assert.assertEquals("abcd", s.removeDuplicates("abcd", 2));
        Assert.assertEquals("aa", s.removeDuplicates("deeedbbcccbdaa", 3));
        Assert.assertEquals("ps", s.removeDuplicates("pbbcggttciiippooaais", 2));
    }

}
