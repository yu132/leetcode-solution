package _0200_0299;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _249  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月7日  
 *  
 */
public class _249 {

    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String each : strings) {
                map.computeIfAbsent(each.length(), (x) -> new ArrayList<>()).add(each);
            }
            List<List<String>> ans = new ArrayList<>();
            for (List<String> list : map.values()) {
                ans.addAll(helper(list));
            }
            return ans;
        }

        public Collection<List<String>> helper(List<String> list) {
            if (list.size() == 1 || list.get(0).length() == 1) {
                List<List<String>> ans = new ArrayList<>();
                ans.add(list);
                return ans;
            }
            Map<String, List<String>> map = new HashMap<>();
            for (String each : list) {
                StringBuilder sb = new StringBuilder(each.length() + 20);
                for (int i = 1; i < each.length(); ++i) {
                    sb.append((each.charAt(i) - each.charAt(i - 1) + 26) % 26).append(" ");
                }
                map.computeIfAbsent(sb.toString(), (x) -> new ArrayList<>()).add(each);
            }
            return map.values();
        }
    }

}
