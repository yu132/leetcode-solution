package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1455  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1455 {

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; ++i) {
                if (words[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.isPrefixOfWord("i love eating burger", "burg"));
        Assert.assertEquals(2, s.isPrefixOfWord("this problem is an easy problem", "pro"));
        Assert.assertEquals(-1, s.isPrefixOfWord("i am tired", "you"));
        Assert.assertEquals(-1, s.isPrefixOfWord("i am tired", "you"));
        Assert.assertEquals(4, s.isPrefixOfWord("i use triple pillow", "pill"));
        Assert.assertEquals(-1, s.isPrefixOfWord("hello from the other side", "they"));
    }

}
