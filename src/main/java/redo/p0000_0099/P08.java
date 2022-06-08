package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P8  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P08 {

    class Solution {
        public int myAtoi(String s) {
            boolean isNum = false, hasOneNum = false, overflow = false;
            int num = 0, sign = 1;
            int MAX_DIV_10 = Integer.MAX_VALUE / 10;
            for (char ch : s.toCharArray()) {
                if (!isNum) {
                    if (ch == ' ') {
                        continue;
                    }
                    isNum = true;
                    if (ch == '+') {
                        continue;
                    } else if (ch == '-') {
                        sign = -1;
                        continue;
                    } else if (Character.isDigit(ch)) {
                        num = num * 10 + (ch - '0');
                        hasOneNum = true;
                    } else {
                        break;
                    }
                } else {
                    if (Character.isDigit(ch)) {
                        hasOneNum = true;
                        if ((num < MAX_DIV_10)) {
                            num = num * 10 + (ch - '0');
                        } else if (num == MAX_DIV_10) {
                            if (sign == 1 && ch - '0' <= 7) {
                                num = num * 10 + (ch - '0');
                                continue;
                            } else if (sign == -1 && ch - '0' <= 8) {
                                num = num * 10 + (ch - '0');
                                continue;
                            }
                            overflow = true;
                            break;
                        } else {
                            overflow = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (!isNum || !hasOneNum) {
                return 0;
            }

            if (overflow) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            return sign * num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(42, s.myAtoi("42"));
        Assert.assertEquals(-42, s.myAtoi("      -42"));
        Assert.assertEquals(4193, s.myAtoi("4193 with words"));
        Assert.assertEquals(0, s.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, s.myAtoi("-91283472332"));
        Assert.assertEquals(0, s.myAtoi("   -+9"));
        Assert.assertEquals(9008, s.myAtoi("   +9008 889"));
        Assert.assertEquals(-2147483648, s.myAtoi("   -2147483648"));
        Assert.assertEquals(-2147483647, s.myAtoi("   -2147483647"));
        Assert.assertEquals(-2147483648, s.myAtoi("   -2147483649"));
        Assert.assertEquals(2147483647, s.myAtoi("   2147483647"));
        Assert.assertEquals(2147483647, s.myAtoi("   2147483648"));

        Assert.assertEquals(0, s.myAtoi("+"));
        Assert.assertEquals(0, s.myAtoi("-"));
        Assert.assertEquals(1, s.myAtoi("01"));
    }

}
