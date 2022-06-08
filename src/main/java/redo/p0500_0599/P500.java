package redo.p0500_0599;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**  
 * @ClassName: P500  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P500 {

    static //

    class Solution {

        //@formatter:off
        private final static Set<Character> LINE_1 =
            new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        private final static Set<Character> LINE_2 =
            new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        private final static Set<Character> LINE_3 = 
            new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));
        //@formatter:on

        public String[] findWords(String[] words) {
            List<String> strs = new ArrayList<>();

            for (String str : words) {
                if (str.equals("")) {
                    strs.add(str);
                }
                contain(str, LINE_1, strs);
                contain(str, LINE_2, strs);
                contain(str, LINE_3, strs);
            }

            return strs.toArray(new String[0]);
        }

        private void contain(String str, Set<Character> line, List<String> strs) {
            if (line.contains(Character.toLowerCase(str.charAt(0)))) {
                for (int i = 1; i < str.length(); ++i) {
                    if (!line.contains(Character.toLowerCase(str.charAt(i)))) {
                        return;
                    }
                }
                strs.add(str);
            }
        }

    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new String[] {"Alaska", "Dad"},
            s.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"}));
    }

}
