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
 * @ClassName: P126  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P126 {

    static//

    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord,
            List<String> wordList) {

            Map<String, List<String>> map = new HashMap<>();

            Map<String, Prev> prev = new HashMap<>();

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
                    meetEnd = true;
                }

                findChild(map, node, queue, visited, prev, level);

                --size;
            }

            return getPath(prev, beginWord, endWord);
        }

        List<List<String>> getPath(Map<String, Prev> prev, String first,
            String end) {

            List<List<String>> ans = new ArrayList<>();

            backtrack(end, first, new ArrayList<>(), ans, prev);

            return ans;
        }

        void backtrack(String str, String first, List<String> list,
            List<List<String>> ans, Map<String, Prev> prev) {

            if (str.equals(first)) {
                list.add(str);

                List<String> temp = new ArrayList<>(list);
                Collections.reverse(temp);

                ans.add(temp);
                list.remove(list.size() - 1);
                return;
            }

            list.add(str);

            if (!prev.containsKey(str)) {
                return;
            }

            for (String p : prev.get(str).prev) {
                backtrack(p, first, list, ans, prev);
            }
            list.remove(list.size() - 1);

        }

        void findChild(Map<String, List<String>> map, String str,
            Deque<String> queue, Set<String> visited, Map<String, Prev> prev,
            int level) {
            char[] chs = str.toCharArray();

            for (int i = 0; i < str.length(); ++i) {
                char temp = chs[i];
                chs[i] = '*';
                for (String child : map.getOrDefault(String.valueOf(chs),
                    Collections.emptyList())) {

                    if (!prev.containsKey(child)) {
                        Prev p = new Prev(level);
                        p.prev.add(str);
                        prev.put(child, p);
                    } else if (prev.get(child).level == level) {
                        prev.get(child).prev.add(str);
                    }

                    if (!visited.contains(child)) {
                        visited.add(child);
                        queue.offer(child);
                    }
                }
                chs[i] = temp;
            }
        }

        static class Prev {
            int level;
            List<String> prev = new ArrayList<>();

            public Prev(int level) {
                super();
                this.level = level;
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
