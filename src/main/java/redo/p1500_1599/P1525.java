package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1525  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1525 {

    class Solution {
        public int numSplits(String s) {
            int[] countLeft = new int[26], countRight = countLowercaseLetters(s);

            int leftCharType = 0, rightCharType = 0, goodSplit = 0;

            for (int num : countRight) {
                if (num != 0) {
                    ++rightCharType;
                }
            }

            for (char ch : s.toCharArray()) {
                if (countLeft[ch - 'a']++ == 0) {
                    ++leftCharType;
                }
                if (--countRight[ch - 'a'] == 0) {
                    --rightCharType;
                }
                if (leftCharType == rightCharType) {
                    ++goodSplit;
                }
            }

            return goodSplit;
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
        Assert.assertEquals(2, s.numSplits("aacaba"));
        Assert.assertEquals(1, s.numSplits("abcd"));
        Assert.assertEquals(4, s.numSplits("aaaaa"));
        Assert.assertEquals(2, s.numSplits("acbadbaada"));
        Assert.assertEquals(3, s.numSplits(
            "jwafowiefowabecfonwopejnfcowqneoirpjqwpocrjpoinweogrnfmjeowcjkpojrpqomrmkdfrngihpwapfkwqefegtribvbituywgebcfbkzxbfciawslnalsdnwqedr"));
    }

}
