package old._0600_0699;

import java.util.Arrays;

/**  
 * @ClassName: _616  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _616 {

    class Solution {
        public String addBoldTag(String s, String[] dict) {
            boolean[] b = new boolean[s.length()];
            for (int i = 0; i < dict.length; ++i) {
                int index = s.indexOf(dict[i]);
                if (index < 0) {
                    continue;
                }
                Arrays.fill(b, index, index + dict[i].length(), true);
                while (true) {
                    index = s.indexOf(dict[i], index + 1);
                    if (index < 0) {
                        break;
                    }
                    Arrays.fill(b, index, index + dict[i].length(), true);
                }
            }
            StringBuilder sb = new StringBuilder(s.length() + 20);
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
                sb.append(s.charAt(i));
            }
            if (tn) {
                sb.append("</b>");
            }
            return sb.toString();
        }

    }


}
