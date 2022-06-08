package redo.p1000_1099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1047  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1047 {

    class Solution {
        public String removeDuplicates(String S) {
            Deque<Character> stack = new LinkedList<>();
            for (char ch : S.toCharArray()) {
                if (!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            StringBuilder buf = new StringBuilder(stack.size());
            while (!stack.isEmpty()) {
                buf.append(stack.removeLast());
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ca", s.removeDuplicates("abbaca"));
    }
}
