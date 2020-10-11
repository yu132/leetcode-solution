package lcci.M10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: M10_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月7日  
 *  
 */
public class M10_02 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, ArrayList<String>> map   = new HashMap<>();

            int[]                          count = new int[26];

            for (String str : strs) {
                for (char each : str.toCharArray()) {
                    ++count[each - 'a'];
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; ++i) {
                    if (count[i] > 0) {
                        sb.append((char)(i + 'a')).append(count[i]);
                    }
                }
                String tag = sb.toString();
                if (map.containsKey(tag)) {
                    map.get(tag).add(str);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(tag, list);
                }
                Arrays.fill(count, 0);
            }

            return new ArrayList<>(map.values());
        }
    }

}
