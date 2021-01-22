package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1328  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1328 {

    class Solution {
        public String breakPalindrome(String palindrome) {
            if (palindrome.length() == 1) {
                return "";
            }
            int index = -1;
            for (int i = 0; i < palindrome.length() / 2; ++i) {
                if (palindrome.charAt(i) != 'a') {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                return palindrome.substring(0, index) + 'a' + palindrome.substring(index + 1);
            } else {
                return palindrome.substring(0, palindrome.length() - 1) + 'b';
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("aaccba", s.breakPalindrome("abccba"));
        Assert.assertEquals("", s.breakPalindrome("a"));
        Assert.assertEquals("acb", s.breakPalindrome("aca"));
        Assert.assertEquals("aaab", s.breakPalindrome("aaaa"));
        Assert.assertEquals("abbc", s.breakPalindrome("cbbc"));
    }

}
