package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P127  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P127 {

    static//

    class Solution {
        public int ladderLength(String beginWord, String endWord,
            List<String> wordList) {

            Map<String, List<String>> map = new HashMap<>();

            for (String word : wordList) {
                add(map, word);
            }

            Deque<String> queue = new LinkedList<>();

            queue.offer(beginWord);

            Set<String> visited = new HashSet<>();

            visited.add(beginWord);

            boolean meetEnd = false;

            int size = 0, level = -1;

            while (!queue.isEmpty()) {

                if (size == 0) {
                    size = queue.size();
                    ++level;
                    if (meetEnd) {
                        break;
                    }
                }

                String node = queue.poll();

                if (node.equals(endWord)) {
                    return level + 1;
                }

                findChild(map, node, queue, visited, level);

                --size;
            }

            return 0;
        }

        void findChild(Map<String, List<String>> map, String str,
            Deque<String> queue, Set<String> visited, int level) {
            char[] chs = str.toCharArray();

            for (int i = 0; i < str.length(); ++i) {
                char temp = chs[i];
                chs[i] = '*';
                for (String child : map.getOrDefault(String.valueOf(chs),
                    Collections.emptyList())) {

                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.offer(child);
                    }
                }
                chs[i] = temp;
            }
        }

        void add(Map<String, List<String>> map, String str) {

            char[] chs = str.toCharArray();

            for (int i = 0; i < str.length(); ++i) {
                char temp = chs[i];
                chs[i] = '*';
                map.computeIfAbsent(String.copyValueOf(chs),
                    (x) -> new ArrayList<>()).add(str);
                chs[i] = temp;
            }
        }
    }

}
