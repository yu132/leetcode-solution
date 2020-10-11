package _1300_1399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**  
 * @ClassName: _1311  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月28日  
 *  
 */
public class _1311 {

    class Solution {

        class Node {
            int id;
            int level;

            public Node(int id, int level) {
                super();
                this.id    = id;
                this.level = level;
            }
        }

        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id,
            int level) {

            LinkedList<Node>     queue   = new LinkedList<>();

            Map<String, Integer> ans     = new HashMap<>();

            HashSet<Integer>     visited = new HashSet<>();

            queue.add(new Node(id, 0));

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                if (visited.contains(node.id)) {
                    continue;
                }
                visited.add(node.id);

                if (node.level < level) {
                    for (int i = 0; i < friends[node.id].length; ++i) {
                        queue.addLast(new Node(friends[node.id][i], node.level + 1));
                    }
                } else {
                    for (String each : watchedVideos.get(node.id)) {
                        ans.put(each, ans.getOrDefault(each, 0) + 1);
                    }
                }
            }

            ArrayList<Entry<String, Integer>> list = new ArrayList<>(ans.entrySet());

            Collections.sort(list, (a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                }
                return Integer.compare(a.getValue(), b.getValue());
            });

            List<String> res = new ArrayList<>();

            for (Entry<String, Integer> entry : list) {
                res.add(entry.getKey());
            }

            return res;
        }
    }

}
