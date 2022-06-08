package lcof;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**  
 * @ClassName: M50  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月21日  
 *  
 */
public class M50 {

    class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> map = new LinkedHashMap<>();

            for (char each : s.toCharArray()) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }

            for (Entry<Character, Integer> each : map.entrySet()) {
                if (each.getValue() == 1) {
                    return each.getKey();
                }
            }
            return ' ';
        }
    }

}
