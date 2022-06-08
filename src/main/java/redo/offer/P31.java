package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P31  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P31 {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            Deque<Integer> stack = new LinkedList<>();

            int n = pushed.length, index1 = 0, index2 = 0;

            while (true) {
                while (!stack.isEmpty() && stack.peek() == popped[index2]) {
                    ++index2;
                    stack.pop();
                }
                if (index2 == n) {
                    return true;
                }
                if (index1 == n) {
                    return false;
                }
                stack.push(pushed[index1++]);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.validateStackSequences(
            new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}));

        Assert.assertEquals(false, s.validateStackSequences(
            new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}));
    }

}
