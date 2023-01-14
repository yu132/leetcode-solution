package old._0600_0699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**  
 * @ClassName: _609  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月1日  
 *  
 */
public class _609 {

    class Solution {
        public List<List<String>> findDuplicate(String[] paths) {

            HashMap<String, List<String>> map = new HashMap<>();

            for (String each : paths) {
                String[] sp = each.split(" ");
                for (int i = 1; i < sp.length; ++i) {
                    int    mid     = sp[i].indexOf('(');
                    String file    = sp[i].substring(0, mid);
                    String content = sp[i].substring(mid + 1, sp[i].length() - 1);
                    map.computeIfAbsent(content, (x) -> new ArrayList<>()).add(sp[0] + "/" + file);
                }
            }

            List<List<String>> list = new ArrayList<>();

            for (List<String> each : map.values()) {
                if (each.size() > 1) {
                    list.add(each);
                }
            }

            return list;
        }
    }

}
