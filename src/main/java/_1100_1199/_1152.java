package _1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @ClassName: _1152  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1152 {

    class Solution {

        class Node {
            String website;
            int timestamp;

            public Node(String website, int timestamp) {
                super();
                this.website   = website;
                this.timestamp = timestamp;
            }
        }

        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

            Map<String, List<Node>> map = new HashMap<>();

            for (int i = 0; i < username.length; ++i) {
                map.computeIfAbsent(username[i], (x) -> new ArrayList<>()).add(new Node(website[i], timestamp[i]));
            }

            List<List<Node>>           list    = new ArrayList<>(map.values());

            Map<String, AtomicInteger> counter = new HashMap<>();

            for (List<Node> each : list) {
                Collections.sort(each, (a, b) -> {
                    return Integer.compare(a.timestamp, b.timestamp);
                });

                Set<String> shown = new HashSet<>(each.size() * (each.size() - 1) * (each.size() - 2));

                for (int i = 0; i < each.size(); ++i) {
                    for (int j = i + 1; j < each.size(); ++j) {
                        for (int k = j + 1; k < each.size(); ++k) {

                            String key = each.get(i).website + " " + each.get(j).website + " " + each.get(k).website;

                            if (shown.contains(key)) {
                                continue;
                            }

                            shown.add(key);

                            counter.computeIfAbsent(key, (x) -> new AtomicInteger(0)).incrementAndGet();
                        }
                    }
                }
            }

            String temp = null;
            int    max  = 0;

            for (Entry<String, AtomicInteger> e : counter.entrySet()) {
                if (e.getValue().get() > max) {
                    max  = e.getValue().get();
                    temp = e.getKey();
                } else if (e.getValue().get() == max) {
                    if (e.getKey().compareTo(temp) < 0) {
                        temp = e.getKey();
                    }
                }
            }

            return Arrays.asList(temp.split(" "));
        }
    }

}
