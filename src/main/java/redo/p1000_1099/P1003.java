package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1003  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1003 {

    static//

    class Solution {
        public boolean isValid(String s) {
            FixedCharArrayStack stack = new FixedCharArrayStack(s.length());
            for (char ch : s.toCharArray()) {
                if (ch != 'c') {
                    stack.push(ch);
                } else {
                    if (stack.size() < 2) {
                        return false;
                    }
                    if (stack.pop() != 'b') {
                        return false;
                    }
                    if (stack.pop() != 'a') {
                        return false;
                    }
                }
            }
            return stack.size() == 0;
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

            public int size() {
                return index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isValid("aabcbc"));
        Assert.assertEquals(true, s.isValid("abcabcababcc"));
        Assert.assertEquals(false, s.isValid("abccba"));
        Assert.assertEquals(false, s.isValid("cababc"));
        Assert.assertEquals(false, s.isValid("a"));
        Assert.assertEquals(false, s.isValid("c"));
        Assert.assertEquals(false, s.isValid("aabbcc"));
        Assert.assertEquals(true, s.isValid("aabcbabcc"));
        Assert.assertEquals(true, s.isValid("aabcbcababcc"));
    }

}
