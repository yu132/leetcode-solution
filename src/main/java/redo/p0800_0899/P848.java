package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P848  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P848 {

    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            long suffix = 0;
            char[] chs = S.toCharArray();
            for (int i = S.length() - 1; i >= 0; --i) {
                suffix = (suffix + shifts[i]) % 26;
                chs[i] = (char)('a' + (chs[i] - 'a' + suffix) % 26);
            }
            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("rpl", s.shiftingLetters("abc", new int[] {3, 5, 9}));
        Assert.assertEquals("w", s.shiftingLetters("a", new int[] {100}));
    }
}
