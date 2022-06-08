package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P856  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P856 {

    class Solution {

        int index;
        String s;

        public int scoreOfParentheses(String S) {
            this.s = S;
            index = 0;
            int p = 0;
            while (index != s.length()) {
                p += h();
            }
            return p;
        }

        public int h() {
            if (s.charAt(index) == '(') {
                ++index;
            }
            if (s.charAt(index) == ')') {// "()"
                ++index;
                return 1;
            }
            int p = 0;
            do {
                p += h();// "AB"
            } while (s.charAt(index) == '(');
            ++index;// ')' "(A)"
            return p * 2;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.scoreOfParentheses("()"));
        Assert.assertEquals(2, s.scoreOfParentheses("(())"));
        Assert.assertEquals(2, s.scoreOfParentheses("()()"));
        Assert.assertEquals(6, s.scoreOfParentheses("(()(()))"));

    }

}
