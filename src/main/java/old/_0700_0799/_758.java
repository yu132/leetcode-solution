package old._0700_0799;

import java.util.Arrays;

/**  
 * @ClassName: _758  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月28日  
 *  
 */
public class _758 {

    class Solution {
        public String boldWords(String[] words, String S) {
            boolean[] b = new boolean[S.length()];
            for (int i = 0; i < words.length; ++i) {
                int index = S.indexOf(words[i]);
                if (index < 0) {
                    continue;
                }
                Arrays.fill(b, index, index + words[i].length(), true);
                while (true) {
                    index = S.indexOf(words[i], index + 1);
                    if (index < 0) {
                        break;
                    }
                    Arrays.fill(b, index, index + words[i].length(), true);
                }
            }
            StringBuilder sb = new StringBuilder(S.length() + 20);
            boolean       tn = false;
            for (int i = 0; i < b.length; ++i) {
                if (b[i]) {
                    if (!tn) {
                        tn = true;
                        sb.append("<b>");
                    }
                } else {
                    if (tn) {
                        tn = false;
                        sb.append("</b>");
                    }
                }
                sb.append(S.charAt(i));
            }
            if (tn) {
                sb.append("</b>");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out
            .println(new _758().new Solution().boldWords(new String[] {"ccb", "b", "d", "cba", "dc"}, "eeaadadadc"));
    }
}
