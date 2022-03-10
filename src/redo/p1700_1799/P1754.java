package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1754  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1754 {

    class Solution {
        public String largestMerge(String word1, String word2) {

            int index1 = 0, index2 = 0;

            StringBuilder buf =
                new StringBuilder(word1.length() + word2.length());

            char[] chs1 = word1.toCharArray(), chs2 = word2.toCharArray();

            while (index1 < word1.length() && index2 < word2.length()) {
                if (compare(chs1, index1, chs2, index2) >= 0) {
                    buf.append(chs1[index1++]);
                } else {
                    buf.append(chs2[index2++]);
                }
            }

            if (index1 != word1.length()) {
                buf.append(word1, index1, word1.length());
            } else {
                buf.append(word2, index2, word2.length());
            }

            return buf.toString();
        }

        int compare(char[] chs1, int index1, char[] chs2, int index2) {
            int n = chs1.length - index1 + chs2.length - index2;
            for (int i = 0; i < n; ++i) {
                char ch1 = get(i, chs1, index1, chs2, index2),
                    ch2 = get(i, chs2, index2, chs1, index1);
                if (ch1 == ch2) {
                    continue;
                }
                return Character.compare(ch1, ch2);
            }
            return 0;
        }

        char get(int index, char[] chs1, int index1, char[] chs2, int index2) {
            if (index + index1 < chs1.length) {
                return chs1[index1 + index];
            } else {
                return chs2[index2 + index - (chs1.length - index1)];
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("cbcabaaaaa", s.largestMerge("cabaa", "bcaaa"));
        Assert.assertEquals("abdcabcabcaba",
            s.largestMerge("abcabc", "abdcaba"));
        Assert.assertEquals("guugguggggggguuggguuggggggg",
            s.largestMerge("guug", "gguggggggguuggguugggggg"));
        Assert.assertEquals(
            "uuuurruuuruuuuuuuuruuuuurrrurrrrrrrruurrrurrrurrrrruu",
            s.largestMerge("uuurruuuruuuuuuuuruuuuu",
                "urrrurrrrrrrruurrrurrrurrrrruu"));
    }

}
