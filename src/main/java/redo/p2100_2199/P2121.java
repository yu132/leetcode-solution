package redo.p2100_2199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2121 {

    class Solution {
        public long[] getDistances(int[] arr) {
            ListMap<Integer, Integer> listMap = new ListMap<>();
            for (int i = 0; i < arr.length; ++i) {
                listMap.add(arr[i], i);
            }
            long[] ans = new long[arr.length];
            for (List<Integer> list : listMap.map.values()) {
                int left = 0, right = list.size();
                long disNow = 0;
                for (int num : list) {
                    disNow += num;
                }
                disNow -= list.get(0) * list.size();
                ans[list.get(0)] = disNow;
                for (int i = 1; i < list.size(); ++i) {
                    ++left;
                    --right;
                    int aToBDis = list.get(i) - list.get(i - 1);
                    disNow += aToBDis * left - aToBDis * right;
                    ans[list.get(i)] = disNow;
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

        }
    }

}
