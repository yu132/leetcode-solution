package _1000_1099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1023  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _1023 {

    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Character> upperCase = new ArrayList<>();
            List<String>    lowerCase = new ArrayList<>();

            int             start     = 0;
            for (int i = 0; i < pattern.length(); ++i) {
                if (pattern.charAt(i) >= 'A' && pattern.charAt(i) <= 'Z') {
                    lowerCase.add(pattern.substring(start, i));
                    upperCase.add(pattern.charAt(i));
                    start = i + 1;
                }
            }
            lowerCase.add(pattern.substring(start));

            List<Boolean> list = new ArrayList<>();

            l:
            for (String each : queries) {
                String lowerC   = lowerCase.get(0);
                int    index4pl = 0, index4plList = 1, index4pu = 0;
                for (char ch : each.toCharArray()) {
                    if (ch >= 'A' && ch <= 'Z') {
                        if (index4pl != lowerC.length()) {
                            list.add(false);
                            continue l;
                        }
                        if (index4pu >= upperCase.size() || ch != upperCase.get(index4pu++)) {
                            list.add(false);
                            continue l;
                        }
                        index4pl = 0;
                        lowerC   = lowerCase.get(index4plList++);
                    } else {
                        if (index4pl != lowerC.length() && lowerC.charAt(index4pl) == ch) {
                            ++index4pl;
                        }
                    }
                }
                list.add(index4pu == upperCase.size());
            }

            return list;
        }

    }

    public static void main(String[] args) {
        System.out.println(new _1023().new Solution()
            .camelMatch(new String[] {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"));
    }
}
