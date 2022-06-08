package _0700_0799;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**  
 * @ClassName: _734  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月28日  
 *  
 */
public class _734 {

    class Solution {
        public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {

            if (words1.length != words2.length) {
                return false;
            }

            HashMap<String, HashSet<String>> map = new HashMap<>();
            for (List<String> each : pairs) {

                HashSet<String> set = map.getOrDefault(each.get(0), new HashSet<>());
                set.add(each.get(1));
                map.put(each.get(0), set);

                set = map.getOrDefault(each.get(1), new HashSet<>());
                set.add(each.get(0));
                map.put(each.get(1), set);
            }

            for (int i = 0; i < words1.length; ++i) {
                if (words1[i].equals(words2[i])) {
                    continue;
                }
                if (!map.containsKey(words1[i])) {
                    return false;
                }
                if (!map.get(words1[i]).contains(words2[i])) {
                    return false;
                }
            }
            return true;
        }
    }

}
