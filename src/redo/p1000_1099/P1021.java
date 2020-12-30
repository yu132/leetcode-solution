package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1021  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1021 {

    class Solution {
        public String removeOuterParentheses(String S) {
            int index = 1, start = 1, count = 0;
            StringBuilder buf = new StringBuilder(S.length());
            while (index < S.length()) {
                if (S.charAt(index) == '(') {
                    ++count;
                } else {
                    --count;
                }
                if (count == -1) {
                    buf.append(S.substring(start, index));
                    count = 0;
                    index += 2;
                    start = index;
                } else {
                    index += 1;
                }
            }
            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("()()()", s.removeOuterParentheses("(()())(())"));
        Assert.assertEquals("()()()()(())", s.removeOuterParentheses("(()())(())(()(()))"));
        Assert.assertEquals("", s.removeOuterParentheses("()()"));
    }
}
