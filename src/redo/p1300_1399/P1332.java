package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1332  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1332 {

    class Solution {
        public int removePalindromeSub(String s) {
            if (s.length() == 0) {
                return 0;
            }
            for (int i = 0; i < s.length() / 2; ++i) {
                if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                    return 2;
                }
            }
            return 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.removePalindromeSub("ababa"));
        Assert.assertEquals(2, s.removePalindromeSub("abb"));
        Assert.assertEquals(2, s.removePalindromeSub("baabb"));
        Assert.assertEquals(0, s.removePalindromeSub(""));
    }

}
