package redo.p0800_0899;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P809  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月31日  
 *  
 */
public class P809 {

    static//

    class Solution {
        public int expressiveWords(String S, String[] words) {
            List<Symbol> symS = toSymbol(S);

            int count = 0;

            next:
            for (String word : words) {

                int index = 0;

                for (int i = 0; i < word.length(); ++i) {

                    if (index == symS.size()) {
                        continue next;
                    }

                    int j = i;
                    while (j + 1 < word.length()
                        && word.charAt(j + 1) == word.charAt(i)) {
                        ++j;
                    }
                    int len = j - i + 1;
                    char ch = word.charAt(i);

                    if (symS.get(index).ch != ch) {
                        continue next;
                    }

                    if (symS.get(index).num <= 2
                        && symS.get(index).num != len) {
                        continue next;
                    }

                    if (symS.get(index).num < len) {
                        continue next;
                    }

                    ++index;

                    i = j;
                }

                if (index == symS.size()) {
                    ++count;
                }
            }

            return count;
        }

        List<Symbol> toSymbol(String s) {

            List<Symbol> sym = new ArrayList<>();

            for (int i = 0; i < s.length(); ++i) {
                int j = i;
                while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(i)) {
                    ++j;
                }
                sym.add(new Symbol(s.charAt(i), j - i + 1));
                i = j;
            }

            return sym;
        }

        static class Symbol {
            char ch;
            int num;

            public Symbol(char ch, int num) {
                super();
                this.ch = ch;
                this.num = num;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.expressiveWords("heeellooo",
            new String[] {"hello", "hi", "helo"}));

        Assert.assertEquals(0, s.expressiveWords("abcd", new String[] {"abc"}));
    }

}
