package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1234  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1234 {

    class Solution {
        public int balancedString(String s) {
            int n = s.length(), left = 0, ans = n;
            int[] count = countUppercaseLetters(s);

            for (int right = 0; right < n; ++right) {
                --count[s.charAt(right) - 'A'];
                while (left < n && count['Q' - 'A'] <= n / 4 && count['W' - 'A'] <= n / 4 && count['E' - 'A'] <= n / 4
                    && count['R' - 'A'] <= n / 4) {
                    ans = Math.min(ans, right - left + 1);
                    ++count[s.charAt(left++) - 'A'];
                }
            }

            return ans;
        }

        public int[] countUppercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'A'];
            }
            return chs;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.balancedString("QWER"));
        Assert.assertEquals(1, s.balancedString("QQWE"));
        Assert.assertEquals(2, s.balancedString("QQQW"));
        Assert.assertEquals(3, s.balancedString("QQQQ"));
    }

}
