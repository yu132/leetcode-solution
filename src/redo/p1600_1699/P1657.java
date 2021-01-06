package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1657  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1657 {

    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) {
                return false;
            }
            int[] count1 = countLowercaseLetters(word1);
            int[] count2 = countLowercaseLetters(word2);
            Arrays.sort(count1);
            Arrays.sort(count2);

            return Arrays.equals(count1, count2) && Arrays.equals(containChars(word1), containChars(word2));
        }

        public int[] countLowercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'a'];
            }
            return chs;
        }

        public boolean[] containChars(String str) {
            boolean[] contains = new boolean[26];
            for (char ch : str.toCharArray()) {
                contains[ch - 'a'] = true;
            }
            return contains;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.closeStrings("abc", "bca"));
        Assert.assertEquals(false, s.closeStrings("a", "aa"));
        Assert.assertEquals(true, s.closeStrings("cabbba", "abbccc"));
        Assert.assertEquals(false, s.closeStrings("cabbba", "aabbss"));
        Assert.assertEquals(false, s.closeStrings("au", "bu"));
        Assert.assertEquals(false, s.closeStrings("uau", "ssx"));
    }

}
