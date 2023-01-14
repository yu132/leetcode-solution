package redo.p2200_2299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2295 {

    class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            ListMap<Integer, Integer> listMap = new ListMap<>();
            for (int i = 0; i < nums.length; ++i) {
                listMap.add(nums[i], i);
            }
            for (int[] op : operations) {
                listMap.get(op[1]).addAll(listMap.get(op[0]));
                listMap.removeKey(op[0]);
            }
            int[] ans = new int[nums.length];
            for (Map.Entry<Integer, List<Integer>> entry : listMap.map.entrySet()) {
                for (int index : entry.getValue()) {
                    ans[index] = entry.getKey();
                }
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

            void removeKey(K key) {
                map.remove(key);
            }
        }
    }

}
