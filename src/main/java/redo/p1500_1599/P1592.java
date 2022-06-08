package redo.p1500_1599;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1592  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1592 {

    class Solution {
        public String reorderSpaces(String text) {
            List<String> words = new ArrayList<>();

            int count = 0;

            StringBuilder temp = new StringBuilder();

            for (char ch : text.toCharArray()) {
                if (ch == ' ') {
                    ++count;
                    if (temp.length() != 0) {
                        words.add(temp.toString());
                        temp = new StringBuilder();
                    }
                } else {
                    temp.append(ch);
                }
            }

            if (temp.length() != 0) {
                words.add(temp.toString());
            }

            int mid;
            int last;

            if (words.size() > 1) {
                mid = count / (words.size() - 1);
                last = count % (words.size() - 1);
            } else {
                mid = 0;
                last = count;
            }

            StringBuilder buf = new StringBuilder(text.length());

            for (int i = 0; i < words.size() - 1; ++i) {
                buf.append(words.get(i));
                for (int j = 0; j < mid; ++j) {
                    buf.append(' ');
                }
            }

            buf.append(words.get(words.size() - 1));

            for (int j = 0; j < last; ++j) {
                buf.append(' ');
            }

            return buf.toString();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("this   is   a   sentence", s.reorderSpaces("  this   is  a sentence "));
        Assert.assertEquals("practice   makes   perfect ", s.reorderSpaces(" practice   makes   perfect"));
        Assert.assertEquals("walks  udp  package  into  bar  a ",
            s.reorderSpaces("  walks  udp package   into  bar a"));
        Assert.assertEquals("hello   world", s.reorderSpaces("hello   world"));
        Assert.assertEquals("a", s.reorderSpaces("a"));
    }
}
