package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2808 {

    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            ListMap<Integer, Integer> indexesMap = new ListMap<>();
            for (int i = 0; i < nums.size(); ++i) {
                indexesMap.add(nums.get(i), i);
            }
            int ans = Integer.MAX_VALUE;
            for (Map.Entry<Integer, List<Integer>> entry : indexesMap.map.entrySet()) {
                int max = 0;
                List<Integer> list = entry.getValue();
                for (int i = 0; i < list.size(); ++i) {
                    max = Math.max(max, (list.get((i + 1) % list.size()) + n - list.get(i) - 1) % n);
                }
                ans = Math.min(ans, (max + 1) / 2);
            }
            return ans;
        }

        class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                get(key).add(element);
            }

            public void remove(K key, E element) {
                get(key).remove(element);
            }

            public List<E> get(K key) {
                return map.computeIfAbsent(key, (x) -> new ArrayList<>());
            }

        }
    }

    public static void main(String[] args) {
        new P2808().new Solution().minimumSeconds(Arrs.buildL("[2,1,3,3,2]"));
    }

}
