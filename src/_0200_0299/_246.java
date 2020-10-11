package _0200_0299;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: _246  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _246 {

    class Solution {
        public boolean isStrobogrammatic(String num) {
            Map<Character, Character> map = new HashMap<>();

            map.put('0', '0');
            map.put('1', '1');
            map.put('8', '8');
            map.put('6', '9');
            map.put('9', '6');

            int f = 0, b = num.length() - 1;
            while (f < b) {
                if (!map.containsKey(num.charAt(f)) || map.get(num.charAt(f)) != num.charAt(b)) {
                    return false;
                }
                ++f;
                --b;
            }
            if (f == b) {
                if (num.charAt(f) == '1' || num.charAt(f) == '0' || num.charAt(f) == '8') {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
