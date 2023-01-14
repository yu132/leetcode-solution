package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

public class P68 {

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            int start = 0, len = 0;
            for (int i = 0; i < words.length; ++i) {
                if (len + words[i].length() <= maxWidth) {
                    len += words[i].length() + 1;
                    continue;
                } else {
                    len = words[i].length() + 1;
                }
                int end = i;

                //只有一个单词，需要特殊处理
                if (end == start + 1) {
                    StringBuilder buf = new StringBuilder(maxWidth);
                    buf.append(words[start]);
                    buf.append(repeat(' ', maxWidth - words[start].length()));
                    ans.add(buf.toString());
                }
                //多个单词
                else {
                    int wordTotalLength = 0;
                    for (int j = start; j < end; ++j) {
                        wordTotalLength += words[j].length();
                    }
                    int avgBlank = (maxWidth - wordTotalLength) / (end - start - 1);
                    int leftBlank = (maxWidth - wordTotalLength) % (end - start - 1);
                    StringBuilder buf = new StringBuilder(maxWidth);
                    buf.append(words[start]);
                    for (int j = start + 1; j < end; ++j) {
                        buf.append(repeat(' ', leftBlank-- > 0 ? avgBlank + 1 : avgBlank));
                        buf.append(words[j]);
                    }
                    ans.add(buf.toString());
                }

                start = end;
            }
            StringBuilder buf = new StringBuilder(maxWidth);
            buf.append(words[start]);
            for (int i = start + 1; i < words.length; ++i) {
                buf.append(' ');
                buf.append(words[i]);
            }
            buf.append(repeat(' ', maxWidth - buf.length()));
            ans.add(buf.toString());
            return ans;
        }

        public String repeat(char ch, int times) {
            StringBuilder buf = new StringBuilder(times);
            for (int i = 0; i < times; ++i) {
                buf.append(ch);
            }
            return buf.toString();
        }
    }

    public static void main(String[] args) {
        new P68().new Solution().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
    }

}
