package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1544  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1544 {

    static//

    class Solution {
        public String makeGood(String s) {
            FixedCharArrayStack stack = new FixedCharArrayStack(s.length());
            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && isSameLetterButDifferentCase(ch, stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return String.copyValueOf(stack.stack, 0, stack.index);
        }

        public boolean isSameLetterButDifferentCase(char ch1, char ch2) {
            return Math.abs(ch1 - ch2) == 'a' - 'A';
        }

        static class FixedCharArrayStack {
            int index = 0;
            char[] stack;

            public FixedCharArrayStack(int len) {
                super();
                this.stack = new char[len];
            }

            public void push(char num) {
                stack[index++] = num;
            }

            public char pop() {
                return stack[--index];
            }

            public char peek() {
                return stack[index - 1];
            }

            public boolean isEmpty() {
                return index == 0;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("leetcode", s.makeGood("leEeetcode"));
        Assert.assertEquals("", s.makeGood("abBAcC"));
        Assert.assertEquals("s", s.makeGood("s"));
    }


}
