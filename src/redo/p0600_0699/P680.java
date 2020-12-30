package redo.p0600_0699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P680  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P680 {

    class Solution {
        public boolean validPalindrome(String s) {
            int low = 0, high = s.length() - 1;

            int neL = -1, neH = -1;

            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    neL = low;
                    neH = high;
                    break;
                }
                ++low;
                --high;
            }

            if (neL == -1) {
                return true;
            }

            low = neL + 1;

            boolean isPalidrome = true;

            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    isPalidrome = false;
                    break;
                }
                ++low;
                --high;
            }

            if (isPalidrome) {
                return true;
            }

            low = neL;
            high = neH - 1;
            isPalidrome = true;

            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    isPalidrome = false;
                    break;
                }
                ++low;
                --high;
            }

            return isPalidrome;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.validPalindrome("aba"));
        Assert.assertEquals(true, s.validPalindrome("abba"));
        Assert.assertEquals(true, s.validPalindrome("acbba"));
        Assert.assertEquals(true, s.validPalindrome("abbac"));
        Assert.assertEquals(true, s.validPalindrome("cabba"));
        Assert.assertEquals(false, s.validPalindrome("aaacabba"));
    }

}
