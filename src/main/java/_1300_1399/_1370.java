package _1300_1399;

/**  
 * @ClassName: _1370  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月12日  
 *  
 */
public class _1370 {

    class Solution {
        public String sortString(String s) {

            int[]         count = new int[26];

            StringBuilder sb    = new StringBuilder(s.length());

            for (char each : s.toCharArray()) {
                ++count[each - 'a'];
            }

            int     index = 0;
            boolean up    = true;

            while (sb.length() < s.length()) {
                if (up) {
                    if (index == 26) {
                        up = false;
                        --index;
                        continue;
                    }
                    if (count[index] > 0) {
                        --count[index];
                        sb.append((char)('a' + index));
                    }
                    ++index;
                } else {
                    if (index == -1) {
                        up = true;
                        ++index;
                        continue;
                    }
                    if (count[index] > 0) {
                        --count[index];
                        sb.append((char)('a' + index));
                    }
                    --index;
                }
            }

            return sb.toString();
        }
    }

}
