package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P468  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P468 {

    class Solution {
        public String validIPAddress(String IP) {
            if (IP == null) {
                return "Neither";
            }
            if (IP.contains(".")) {
                if (isIPv4(IP)) {
                    return "IPv4";
                }
            } else if (IP.contains(":")) {
                if (isIPv6(IP)) {
                    return "IPv6";
                }
            }
            return "Neither";
        }

        boolean isIPv4(String str) {
            if (str.charAt(str.length() - 1) == '.') {
                return false;
            }
            String[] sp = str.split("\\.");
            if (sp.length != 4) {
                return false;
            }
            for (String part : sp) {

                if (part.length() == 0
                    || (part.length() != 1 && part.startsWith("0"))
                    || part.length() > 3) {
                    return false;
                }

                int num = 0;
                for (char ch : part.toCharArray()) {
                    if (!Character.isDigit(ch)) {
                        return false;
                    }
                    num = num * 10 + ch - '0';
                }
                if (num > 255) {
                    return false;
                }
            }
            return true;
        }

        boolean isIPv6(String str) {
            if (str.charAt(str.length() - 1) == ':') {
                return false;
            }
            String[] sp = str.split("\\:");
            if (sp.length != 8) {
                return false;
            }
            for (String part : sp) {
                if (part.length() == 0 || part.length() > 4) {
                    return false;
                }
                part = part.toUpperCase();
                for (char ch : part.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        continue;
                    }
                    if ('A' <= ch && ch <= 'F') {
                        continue;
                    }
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("IPv4", s.validIPAddress("1.1.1.1"));
    }
}
