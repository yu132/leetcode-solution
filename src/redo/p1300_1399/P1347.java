package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1347  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1347 {

    class Solution {
        public int minSteps(String s, String t) {
            int[] c1 = countLowercaseLetters(s), c2 = countLowercaseLetters(t);
            int diff = 0;
            for (int i = 0; i < 26; ++i) {
                diff += Math.abs(c1[i] - c2[i]);
            }
            return diff / 2;
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
        Assert.assertEquals(1, s.minSteps("bab", "aba"));
        Assert.assertEquals(5, s.minSteps("leetcode", "practice"));
        Assert.assertEquals(0, s.minSteps("anagram", "mangaar"));
        Assert.assertEquals(0, s.minSteps("xxyyzz", "xxyyzz"));
        Assert.assertEquals(4, s.minSteps("friend", "family"));
    }

}
