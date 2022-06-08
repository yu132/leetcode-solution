package _0200_0299;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: _288  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _288 {

    class ValidWordAbbr {

        private Map<String, String> map = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String each : dictionary) {
                String abbr = each.length() > 2
                    ? each.charAt(0) + String.valueOf(each.length() - 2) + each.charAt(each.length() - 1) : each;
                if (map.containsKey(abbr) && !map.get(abbr).equals(each)) {
                    map.put(abbr, "1");
                } else {
                    map.put(abbr, each);
                }
            }
        }

        public boolean isUnique(String word) {
            String abbr = word.length() > 2
                ? word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1) : word;
            return !map.containsKey(abbr) || map.get(abbr).equals(word);
        }
    }

}
