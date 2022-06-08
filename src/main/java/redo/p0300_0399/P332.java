package redo.p0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**  
 * @ClassName: P332  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P332 {

    static//

    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {

            Map<String, TreeMap<String, int[]>> adjc = toAdjc(tickets);

            List<String> path = new ArrayList<>();

            path.add("JFK");

            backtrack("JFK", path, tickets.size() + 1, adjc);

            return path;
        }

        final static TreeMap<String, int[]> NULL = new TreeMap<>();

        boolean backtrack(String str, List<String> path, int n,
            Map<String, TreeMap<String, int[]>> adjc) {

            if (path.size() == n) {
                return true;
            }

            for (Map.Entry<String, int[]> endAndCount : adjc
                .getOrDefault(str, NULL).entrySet()) {
                int[] count = endAndCount.getValue();
                if (count[0] == 0) {
                    continue;
                }
                String end = endAndCount.getKey();
                --count[0];
                path.add(end);
                if (backtrack(end, path, n, adjc)) {
                    return true;
                }
                path.remove(path.size() - 1);
                ++count[0];
            }

            return false;
        }

        Map<String, TreeMap<String, int[]>> toAdjc(List<List<String>> tickets) {

            Map<String, TreeMap<String, int[]>> adjc = new HashMap<>();

            for (List<String> edge : tickets) {

                String start = edge.get(0), end = edge.get(1);

                TreeMap<String, int[]> innerMap =
                    adjc.computeIfAbsent(start, (x) -> new TreeMap<>());

                innerMap.computeIfAbsent(end, (x) -> new int[1])[0]++;
            }

            return adjc;
        }
    }

}
