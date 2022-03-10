package redo.p1800_1899;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P1807  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1807 {

    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> mapping = new HashMap<>();
            for (List<String> list : knowledge) {
                mapping.put(list.get(0), list.get(1));
            }

            StringBuilder buf = new StringBuilder(s.length());

            int lastIndex = -1;

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    buf.append(s, lastIndex + 1, i);
                    lastIndex = i;
                } else if (s.charAt(i) == ')') {
                    buf.append(mapping
                        .getOrDefault(s.substring(lastIndex + 1, i), "?"));
                    lastIndex = i;
                }
            }

            buf.append(s, lastIndex + 1, s.length());

            return buf.toString();
        }
    }

}
