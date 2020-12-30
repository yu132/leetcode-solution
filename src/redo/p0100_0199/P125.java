package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P125  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P125 {

    class Solution {
        public boolean isPalindrome(String s) {
            int low = 0, high = s.length() - 1;
            while (low < high) {
                while (low < high && !isNumberOrLetter(s.charAt(low))) {
                    ++low;
                }
                while (low < high && !isNumberOrLetter(s.charAt(high))) {
                    --high;
                }
                if (low >= high) {
                    break;
                }
                if (lower(s.charAt(low)) != lower(s.charAt(high))) {
                    return false;
                }
                ++low;
                --high;
            }
            return true;
        }

        private char lower(char ch) {
            return Character.toLowerCase(ch);
        }

        private boolean isNumberOrLetter(char ch) {
            return Character.isDigit(ch) || Character.isLetter(ch);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(!s.isPalindrome("race a car"));
        assertTrue(s.isPalindrome("   "));
    }
}
