package _1400_1499;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: _1436  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月18日  
 *  
 */
public class _1436 {

    class Solution {
        public String destCity(List<List<String>> paths) {

            Set<String> set = new HashSet<>();

            for (List<String> each : paths) {
                set.add(each.get(0));
            }

            for (List<String> each : paths) {
                if (!set.contains(each.get(1))) {
                    return each.get(1);
                }
            }

            return "";
        }
    }

}
