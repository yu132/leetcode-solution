package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1684  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1684 {

    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            boolean[] allow = new boolean[26];
            for (char ch : allowed.toCharArray()) {
                allow[ch - 'a'] = true;
            }
            int count = 0;
            for (String word : words) {
                if (in(word, allow)) {
                    ++count;
                }
            }
            return count;
        }

        public boolean in(String str, boolean[] allow) {
            for (char ch : str.toCharArray()) {
                if (!allow[ch - 'a']) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.countConsistentStrings("ab", new String[] {"ad", "bd", "aaab", "baa", "badab"}));
        Assert.assertEquals(7, s.countConsistentStrings("abc", new String[] {"a", "b", "c", "ab", "ac", "bc", "abc"}));
        Assert.assertEquals(4,
            s.countConsistentStrings("cad", new String[] {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));

    }

}
