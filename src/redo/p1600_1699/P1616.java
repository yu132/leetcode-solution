package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1616  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1616 {

    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            return check(a, b) || check(b, a);
        }

        public boolean check(String a, String b) {
            int low = a.length() / 2 - ((a.length() & 1) ^ 1), high = a.length() / 2;
            while (low >= 0 && a.charAt(low) == a.charAt(high)) {
                --low;
                ++high;
            }
            if (low == -1 && high == a.length()) {
                return true;
            }
            int ll = low, hh = high;
            while (ll >= 0 && a.charAt(ll) == b.charAt(hh)) {
                --ll;
                ++hh;
            }
            if (ll == -1 && hh == a.length()) {
                return true;
            }
            ll = low;
            hh = high;
            while (ll >= 0 && b.charAt(ll) == a.charAt(hh)) {
                --ll;
                ++hh;
            }
            if (ll == -1 && hh == a.length()) {
                return true;
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.check("x", "y"));
        Assert.assertEquals(true, s.check("ulacfd", "jizalu"));
        Assert.assertEquals(false, s.check("abcd", "edfh"));
        Assert.assertEquals(true, s.check("abbbb", "dbbba"));
    }

}
