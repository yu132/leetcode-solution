package redo.p0000_0099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P71  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P71 {

    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<>();

            for (String str : path.split("\\/")) {
                if (str.equals(".") || str.equals("")) {
                    continue;
                } else if (str.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(str);
                }
            }

            if (stack.isEmpty()) {
                return "/";
            }

            StringBuilder buf = new StringBuilder(100);

            while (!stack.isEmpty()) {
                buf.append('/').append(stack.pollLast());
            }

            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("/home", s.simplifyPath("/home/"));
    }

}
