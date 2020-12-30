package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P953  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P953 {

    class Solution {
        int[] charIndex;

        public boolean isAlienSorted(String[] words, String order) {
            charIndex = new int[26];
            for (int i = 0; i < order.length(); ++i) {
                charIndex[order.charAt(i) - 'a'] = i + 1;
            }

            for (int i = 1; i < words.length; ++i) {
                if (compare(words[i - 1], words[i]) > 0) {
                    return false;
                }
            }

            return true;
        }

        public int compare(String str1, String str2) {
            for (int i = 0, len = Math.max(str1.length(), str2.length()); i < len; ++i) {
                int i1 = index(str1, i);
                int i2 = index(str2, i);
                if (i1 < i2) {
                    return -1;
                } else if (i1 > i2) {
                    return 1;
                }
            }
            return 0;
        }

        public int index(String str, int index) {
            if (index >= str.length()) {
                return 0;
            }
            return charIndex[str.charAt(index) - 'a'];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isAlienSorted(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertEquals(false,
            s.isAlienSorted(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertEquals(false, s.isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));

    }
}
