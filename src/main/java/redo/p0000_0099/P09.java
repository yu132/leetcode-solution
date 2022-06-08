package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P9  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月16日  
 *  
 */
public class P09 {

    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            List<Integer> digits = new ArrayList<>(10);
            while (x > 0) {
                digits.add(x % 10);
                x /= 10;
            }
            for (int i = 0, j = digits.size() - 1; i < j; ++i, --j) {
                if (digits.get(i) != digits.get(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome(121));
        assertTrue(!s.isPalindrome(-121));
        assertTrue(!s.isPalindrome(10));
    }

}
