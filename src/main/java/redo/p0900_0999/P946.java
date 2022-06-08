package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P946  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P946 {

    static//

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            FixedIntArrayStack stack = new FixedIntArrayStack(pushed.length);
            int iPush = 0, iPop = 0;
            while (iPush < pushed.length) {
                while (iPush < pushed.length && (stack.isEmpty() || stack.peek() != popped[iPop])) {
                    stack.push(pushed[iPush++]);
                }
                while (!stack.isEmpty() && stack.peek() == popped[iPop]) {
                    ++iPop;
                    stack.pop();
                }
            }
            return stack.isEmpty();
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
        Assert.assertEquals(true, s.validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}));
        Assert.assertEquals(false, s.validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}));
    }

}
