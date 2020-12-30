package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P804  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P804 {

    static//

    class Solution {

        private final static String[] MORSE =
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        public int uniqueMorseRepresentations(String[] words) {
            Set<String> set = new HashSet<>();
            for (String str : words) {
                StringBuilder sb = new StringBuilder(str.length() * 4);
                for (char ch : str.toCharArray()) {
                    sb.append(MORSE[ch - 'a']);
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
    }

}
