package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1451  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1451 {

    class Solution {
        public String arrangeWords(String text) {
            List<String> strs = splitAndRemoveEmpty(text, ' ');
            strs.set(0, strs.get(0).toLowerCase());
            Collections.sort(strs, (a, b) -> Integer.compare(a.length(), b.length()));
            StringBuilder buf = new StringBuilder(text.length());
            buf.append(uppercaseFirstChar(strs.get(0)));
            for (int i = 1; i < strs.size(); ++i) {
                buf.append(' ').append(strs.get(i));
            }
            return buf.toString();

        }

        public String uppercaseFirstChar(String str) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }

        // 使用某个单独字符进行切分，切分后不保留空字符串，即将多个spliter当作一个来处理
        public List<String> splitAndRemoveEmpty(String str, char spliter) {
            int start = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == spliter) {
                    if (start == i) {
                        ++start;
                        continue;
                    }

                    ans.add(str.substring(start, i));

                    start = i + 1;
                }
            }

            if (start != str.length()) {
                ans.add(str.substring(start));
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Is cool leetcode", s.arrangeWords("Leetcode is cool"));
        Assert.assertEquals("On and keep calm code", s.arrangeWords("Keep calm and code on"));
        Assert.assertEquals("To be or to be not", s.arrangeWords("To be or not to be"));
    }

}
