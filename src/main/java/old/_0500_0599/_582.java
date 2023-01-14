package old._0500_0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: _582  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月13日  
 *  
 */
public class _582 {

    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < pid.size(); ++i) {
                map.computeIfAbsent(ppid.get(i), (x) -> new ArrayList<>()).add(pid.get(i));
            }

            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(kill);

            List<Integer> ans = new ArrayList<>();

            while (!queue.isEmpty()) {
                Integer id = queue.removeFirst();
                ans.add(id);
                if (map.containsKey(id)) {
                    queue.addAll(map.get(id));
                }
            }

            return ans;
        }
    }

}
