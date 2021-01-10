package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1433  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1433 {

    class Solution {
        public boolean checkIfCanBreak(String s1, String s2) {
            int[] c1 = countLowercaseLetters(s1), c2 = countLowercaseLetters(s2);
            return check(c1, c2) || check(c2, c1);
        }

        public boolean check(int[] c1, int[] c2) {
            int needGreater = 0;
            for (int i = 0; i < 26; ++i) {
                if (c1[i] > c2[i]) {
                    needGreater += c1[i] - c2[i];
                } else if (c1[i] < c2[i]) {
                    needGreater -= c2[i] - c1[i];
                    if (needGreater < 0) {
                        return false;
                    }
                }
            }
            return true;
        }

        public int[] countLowercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'a'];
            }
            return chs;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.checkIfCanBreak("abc", "xya"));
        Assert.assertEquals(false, s.checkIfCanBreak("abe", "acd"));
        Assert.assertEquals(true, s.checkIfCanBreak("leetcodee", "interview"));
        Assert.assertEquals(true, s.checkIfCanBreak("szy", "cid"));
    }

}
