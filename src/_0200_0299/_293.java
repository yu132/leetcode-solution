package _0200_0299;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _293  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _293 {

    class Solution {
        public List<String> generatePossibleNextMoves(String s) {
            List<String> list = new ArrayList<>();

            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                    list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
                }
            }

            return list;
        }
    }

}
