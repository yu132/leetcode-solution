package redo.p2000_2099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class P2080 {

    class RangeFreqQuery {

        ListMap<Integer, Integer> listMap = new ListMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; ++i) {
                listMap.add(arr[i], i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = listMap.get(value);
            int minIndex = binarySearchMin(0, list.size(), mid -> list.get(mid) >= left);
            int maxIndex = binarySearchMax(0, list.size(), mid -> list.get(mid) <= right);
            return maxIndex + 1 - minIndex;
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

        // 寻找符合条件的最小值
        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        // 寻找符合条件的最大值
        public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }
    }


}
