package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P482  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P482 {

    class Solution {
        public String licenseKeyFormatting(String S, int K) {
            int len = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = S.length() - 1; i >= 0; --i) {
                char ch = S.charAt(i);
                if (ch == '-') {
                    continue;
                }
                sb.append(Character.toUpperCase(ch));
                ++len;
                if (len == K) {
                    sb.append('-');
                    len = 0;
                }
            }
            String ans = sb.reverse().toString();
            if (ans.startsWith("-")) {
                return ans.substring(1);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("5F3Z-2E9W", s.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        assertEquals("2-5G-3J", s.licenseKeyFormatting("2-5g-3-J", 2));
    }

}
