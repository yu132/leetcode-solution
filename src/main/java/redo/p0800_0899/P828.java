package redo.p0800_0899;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P828 {

    class Solution {
        public int uniqueLetterString(String s) {
            ListMap<Character> listMap = new ListMap<>();
            for (int i = 0; i < s.length(); ++i) {
                listMap.add(s.charAt(i), i);
            }
            int ans = 0;
            for (List<Integer> list : listMap.map.values()) {
                list.add(s.length());
                for (int i = 1; i < list.size() - 1; ++i) {
                    ans += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
                }
            }
            return ans;
        }

        class ListMap<K> {

            Map<K, List<Integer>> map = new HashMap<>();

            public void add(K key, Integer element) {
                get(key).add(element);
            }

            public void remove(K key, Integer element) {
                get(key).remove(element);
            }

            public List<Integer> get(K key) {
                return map.computeIfAbsent(key, (x) -> {
                    List<Integer> list = new ArrayList<>();
                    list.add(-1);
                    return list;
                });
            }

        }
    }

}
