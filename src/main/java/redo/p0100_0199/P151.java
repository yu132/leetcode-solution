package redo.p0100_0199;

/**  
 * @ClassName: P151  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P151 {
    class Solution {
        public String reverseWords(String s) {
            StringBuilder buf = new StringBuilder(s.length());

            int end = -1;
            boolean first = true;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (end == -1 && s.charAt(i) != ' ') {
                    end = i + 1;
                } else if (s.charAt(i) == ' ' && end != -1) {
                    if (!first) {
                        buf.append(' ');
                    } else {
                        first = false;
                    }
                    buf.append(s, i + 1, end);
                    end = -1;
                }
            }

            if (end != -1) {
                if (!first) {
                    buf.append(' ');
                } else {
                    first = false;
                }
                buf.append(s, 0, end);
            }

            return buf.toString();
        }
    }
}
