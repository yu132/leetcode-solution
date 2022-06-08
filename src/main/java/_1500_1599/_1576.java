package _1500_1599;

/**  
 * @ClassName: _1576  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月8日  
 *  
 */
public class _1576 {

    class Solution {
        public String modifyString(String s) {
            char[] c = s.toCharArray();
            if (c.length == 1) {
                if (c[0] == '?') {
                    return "a";
                } else {
                    return s;
                }
            }
            if (c[0] == '?') {
                if (c[1] == 'a') {
                    c[0] = 'b';
                } else {
                    c[0] = 'a';
                }
            }
            if (c[c.length - 1] == '?') {
                if (c[c.length - 2] == 'a') {
                    c[c.length - 1] = 'b';
                } else {
                    c[c.length - 1] = 'a';
                }
            }

            for (int i = 1; i < c.length - 1; ++i) {
                if (c[i] == '?') {
                    char ch = 'a';
                    while (ch == c[i - 1] || ch == c[i + 1]) {
                        ++ch;
                    }
                    c[i] = ch;
                }
            }
            return String.valueOf(c);
        }
    }

}
