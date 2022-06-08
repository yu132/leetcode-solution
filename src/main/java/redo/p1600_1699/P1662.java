package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1662  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1662 {

    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

            int index1Word = 0, index1Char = 0, index2Word = 0, index2Char = 0;
            while (index1Word < word1.length && index2Word < word2.length) {
                if (word1[index1Word].charAt(index1Char) != word2[index2Word].charAt(index2Char)) {
                    return false;
                }
                ++index1Char;
                ++index2Char;
                if (index1Char == word1[index1Word].length()) {
                    ++index1Word;
                    index1Char = 0;
                }
                if (index2Char == word2[index2Word].length()) {
                    ++index2Word;
                    index2Char = 0;
                }
            }
            return index1Word == word1.length && index2Word == word2.length;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        Assert.assertEquals(false, s.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab", "c"}));
        Assert.assertEquals(true, s.arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));

    }

}
