package redo.p0400_0499;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P433  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月17日  
 *  
 */
public class P433 {

    class Solution {
        public int minMutation(String start, String end, String[] bank) {

            Map<String, Set<String>> adjc = toAjdc(start, bank);

            Deque<String> queue = new LinkedList<>();

            queue.offer(start);

            Set<String> visited = new HashSet<>();

            visited.add(start);

            int level = -1, size = 0;

            while (!queue.isEmpty()) {
                if (size == 0) {
                    ++level;
                    size = queue.size();
                }

                String node = queue.poll();

                if (end.equals(node)) {
                    return level;
                }

                for (String child : adjc.getOrDefault(node,
                    Collections.emptySet())) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.offer(child);
                    }
                }

                --size;
            }

            return -1;
        }

        Map<String, Set<String>> toAjdc(String start, String[] bank) {
            Map<String, Set<String>> adjc = new HashMap<>();

            for (int i = 1; i < bank.length; ++i) {
                for (int j = 0; j < i; ++j) {
                    String s1 = bank[i], s2 = bank[j];
                    if (diff1(s1, s2)) {
                        add(adjc, s1, s2);
                        add(adjc, s2, s1);
                    }
                }
            }

            for (int i = 0; i < bank.length; ++i) {
                String s1 = bank[i], s2 = start;
                if (diff1(s1, s2)) {
                    add(adjc, s1, s2);
                    add(adjc, s2, s1);
                }
            }

            return adjc;
        }

        void add(Map<String, Set<String>> adjc, String from, String to) {
            adjc.computeIfAbsent(from, (x) -> new HashSet<>()).add(to);
        }

        boolean diff1(String str1, String str2) {
            int count = 0;
            for (int i = 0; i < 8; ++i) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    ++count;
                }
            }
            return count == 1;
        }
    }

}
