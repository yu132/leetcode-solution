package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P831  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P831 {

    class Solution {
        public String maskPII(String S) {
            int index;
            if ((index = S.indexOf('@')) >= 0) {// email
                return safeEmail(S, index);
            } else {
                return safePhoneNumer(S);
            }
        }

        private String safePhoneNumer(String phoneNumber) {
            StringBuilder buf = new StringBuilder(phoneNumber.length());
            int num = 0, f = 0;
            for (int i = phoneNumber.length() - 1; i >= 0; --i) {
                char ch = phoneNumber.charAt(i);
                if (!Character.isDigit(ch)) {
                    continue;
                }
                ++num;

                if (f == 1 && num == 4) {
                    buf.append('-');
                }

                if (buf.length() < 4) {
                    buf.append(ch);
                } else {
                    buf.append('*');
                }
                if (f == 0) {
                    if (num == 4) {
                        num = 0;
                        f = 1;
                        buf.append('-');
                    }
                } else {
                    if (buf.length() < 12 && num == 3) {
                        num = 0;
                        buf.append('-');
                    }
                }
            }
            if (buf.length() > 12) {
                buf.append('+');
            }
            return buf.reverse().toString();
        }

        public String safeEmail(String email, int indexAt) {
            char ch1 = Character.toLowerCase(email.charAt(0)), ch2 = Character.toLowerCase(email.charAt(indexAt - 1));
            return ch1 + "*****" + ch2 + email.substring(indexAt).toLowerCase();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals("l*****e@leetcode.com", s.maskPII("LeetCode@LeetCode.com"));
        // Assert.assertEquals("a*****b@qq.com", s.maskPII("AB@qq.com"));
        Assert.assertEquals("***-***-7890", s.maskPII("1(234)567-890"));
        Assert.assertEquals("+**-***-***-5678", s.maskPII("86-(10)12345678"));
    }

}
