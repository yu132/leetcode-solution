package redo.p1400_1499;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1410  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1410 {

    static//

    class Solution {

        private final static Map<String, Character> TAB = new HashMap<>();

        static {
            TAB.put("quot", '\"');
            TAB.put("apos", '\'');
            TAB.put("amp", '&');
            TAB.put("gt", '>');
            TAB.put("lt", '<');
            TAB.put("frasl", '/');
        }

        public String entityParser(String text) {
            int start = 0;

            StringBuilder buf = new StringBuilder(text.length());

            for (int i = 0; i < text.length(); ++i) {
                if (text.charAt(i) == '&') {
                    buf.append(text, start, i);
                    start = i;
                } else if (text.charAt(i) == ';') {
                    String key = text.substring(start + 1, i);
                    if (TAB.containsKey(key)) {
                        buf.append(TAB.get(key));
                    } else {
                        buf.append(text, start, i + 1);
                    }
                    start = i + 1;
                }
            }

            if (start != text.length()) {
                buf.append(text, start, text.length());
            }

            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("& is an HTML entity but &ambassador; is not.",
            s.entityParser("&amp; is an HTML entity but &ambassador; is not."));

        Assert.assertEquals("and I quote: \"...\"", s.entityParser("and I quote: &quot;...&quot;"));

        Assert.assertEquals("Stay home! Practice on Leetcode :)", s.entityParser("Stay home! Practice on Leetcode :)"));

        Assert.assertEquals("x > y && x < y is always false",
            s.entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));

        Assert.assertEquals("leetcode.com/problemset/all", s.entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }

}
