package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1456  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1456 {

    class Solution {
        public int maxVowels(String s, int k) {
            int count = 0;
            for (int i = 0; i < k; ++i) {
                if (isLowercaseVowel(s.charAt(i))) {
                    ++count;
                }
            }

            int max = count;

            for (int i = k, j = 0; i < s.length(); ++i, ++j) {
                if (isLowercaseVowel(s.charAt(j))) {
                    --count;
                }
                if (isLowercaseVowel(s.charAt(i))) {
                    ++count;
                }

                max = Math.max(max, count);
            }

            return max;
        }

        public boolean isLowercaseVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxVowels("abciiidef", 3));
        Assert.assertEquals(2, s.maxVowels("aeiou", 2));
        Assert.assertEquals(2, s.maxVowels("leetcode", 3));
        Assert.assertEquals(0, s.maxVowels("rhythms", 4));
        Assert.assertEquals(1, s.maxVowels("tryhard", 4));
    }

}
