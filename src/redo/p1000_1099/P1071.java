package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1071  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1071 {

    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if ((str1 + str2).equals(str2 + str1)) {
                return str1.substring(0, gcd(str1.length(), str2.length()));
            }
            return "";
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ABC", s.gcdOfStrings("ABCABC", "ABC"));
        Assert.assertEquals("AB", s.gcdOfStrings("ABABAB", "ABAB"));
        Assert.assertEquals("", s.gcdOfStrings("LEET", "CODE"));
    }

}
