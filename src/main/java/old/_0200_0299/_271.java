package old._0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _271  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月9日  
 *  
 */
public class _271 {

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String each : strs) {
                for (char ch : each.toCharArray()) {
                    if (ch != '#') {
                        sb.append(ch);
                    } else {
                        sb.append("##");
                    }
                }
                sb.append("# ");
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String>  ans = new ArrayList<>();
            StringBuilder sb  = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != '#') {
                    sb.append(s.charAt(i));
                } else {
                    if (s.charAt(i + 1) == '#') {
                        sb.append('#');
                        ++i;
                    } else {
                        ++i;
                        ans.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
            }
            return ans;
        }
    }

}
