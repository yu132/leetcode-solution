package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P20  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P20 {

    class Solution {

        String s;
        int index;

        public boolean isNumber(String s) {
            this.s = s.trim();
            index = 0;
            return isValue();
        }

        public boolean isValue() {
            if (index == s.length()) {// 为空
                return false;
            }
            if (ch() == '+' || ch() == '-') {
                advance();
            }
            if (index == s.length()) {// 只包含+或者-
                return false;
            }

            // .前后都可以没有数字，但是不能同时没有
            int lenToCheck = 0;

            lenToCheck += num();

            if (index == s.length()) {// 不带.或者e的最短可接受数值
                return true;
            }
            if (ch() == '.') {
                advance();
                lenToCheck += num();
            }

            if (lenToCheck == 0) {// .两边都没有数字
                return false;
            }

            if (index == s.length()) {// 不带e的可接受数值
                return true;
            }
            if (ch() == 'e' || ch() == 'E') {
                advance();
                if (index == s.length()) {// e后面什么都不带非法
                    return false;
                }
                if (ch() == '+' || ch() == '-') {// e后可接符号
                    advance();
                }
                if (num() == 0) {// e后必须带数字
                    return false;
                }
            }
            return index == s.length();// 不接受其余非法字符
        }

        // 返回长度
        public int num() {
            int len = 0;
            while (index != s.length() && Character.isDigit(ch())) {
                ++len;
                advance();
            }
            return len;
        }

        public void advance() {
            ++index;
        }

        public char ch() {
            return s.charAt(index);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isNumber("+100"));
        Assert.assertEquals(true, s.isNumber("5e2"));
        Assert.assertEquals(true, s.isNumber("-123"));
        Assert.assertEquals(true, s.isNumber("-1E-16"));
        Assert.assertEquals(true, s.isNumber("0123"));

        Assert.assertEquals(true, s.isNumber("1 "));

        Assert.assertEquals(true, s.isNumber(".1"));
        Assert.assertEquals(true, s.isNumber("1."));

        Assert.assertEquals(false, s.isNumber("+"));

        Assert.assertEquals(false, s.isNumber("."));

        Assert.assertEquals(false, s.isNumber("12e"));
        Assert.assertEquals(false, s.isNumber("1a3.14"));
        Assert.assertEquals(false, s.isNumber("1.2.3"));
        Assert.assertEquals(false, s.isNumber("+-5"));
        Assert.assertEquals(false, s.isNumber("12e+5.4"));
    }
}
