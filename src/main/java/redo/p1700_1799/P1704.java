package redo.p1700_1799;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1704  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1704 {

    static//

    class Solution {

        public final static Set<Character> VOWELS =
            new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        public boolean halvesAreAlike(String s) {
            int count = 0;
            for (int i = 0; i < s.length() / 2; ++i) {
                if (VOWELS.contains(s.charAt(i))) {
                    ++count;
                }
            }
            for (int i = s.length() / 2; i < s.length(); ++i) {
                if (VOWELS.contains(s.charAt(i))) {
                    --count;
                }
            }
            return count == 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.halvesAreAlike("book"));
        Assert.assertEquals(false, s.halvesAreAlike("textbook"));
        Assert.assertEquals(false, s.halvesAreAlike("MerryChristmas"));
        Assert.assertEquals(true, s.halvesAreAlike("AbCdEfGh"));
    }

}
