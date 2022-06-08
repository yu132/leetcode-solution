package redo.p1200_1299;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1249  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1249 {

    static//

    class Solution {
        public String minRemoveToMakeValid(String s) {
            FixedIntArrayStack stackLeft = new FixedIntArrayStack(s.length()),
                stackRight = new FixedIntArrayStack(s.length());

            Set<Integer> poped = new HashSet<>();

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    while (!stackRight.isEmpty()) {
                        if (stackLeft.isEmpty()) {
                            poped.add(stackRight.pop());
                        } else {
                            stackLeft.pop();
                            stackRight.pop();
                        }
                    }
                    stackLeft.push(i);
                } else if (s.charAt(i) == ')') {
                    stackRight.push(i);
                }
            }
            while (!stackRight.isEmpty()) {
                if (stackLeft.isEmpty()) {
                    poped.add(stackRight.pop());
                } else {
                    stackLeft.pop();
                    stackRight.pop();
                }
            }
            while (!stackLeft.isEmpty()) {
                poped.add(stackLeft.pop());
            }

            StringBuilder buf = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); ++i) {
                if (!poped.contains(i)) {
                    buf.append(s.charAt(i));
                }
            }

            return buf.toString();
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
        Assert.assertEquals("lee(t(co)de)", s.minRemoveToMakeValid("lee(t(c)o)de)"));
        Assert.assertEquals("ab(c)d", s.minRemoveToMakeValid("a)b(c)d"));
        Assert.assertEquals("", s.minRemoveToMakeValid("))(("));
        Assert.assertEquals("a(b(c)d)", s.minRemoveToMakeValid("(a(b(c)d)"));
    }

}
