package redo.p2100_2199;

import java.util.*;

public class P2115 {

    static
    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            ToIntMap<String> toIntMap = new ToIntMap<>();
            ListMap<Integer, Integer> out = new ListMap<>();
            Counter<Integer> inCount = new Counter<>();

            Map<Integer, String> target = new HashMap<>();
            for (String recipe : recipes) {
                target.put(toIntMap.getIndex(recipe), recipe);
            }

            for (int i = 0; i < ingredients.size(); ++i) {
                int child = toIntMap.getIndex(recipes[i]);
                for (String item : ingredients.get(i)) {
                    int parent = toIntMap.getIndex(item);
                    inCount.plus1(child);
                    out.add(parent, child);
                }
            }
            LinkedList<Integer> queue = new LinkedList<>();
            for (String supply : supplies) {
                queue.offer(toIntMap.getIndex(supply));
            }

            List<String> ans = new ArrayList<>();

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int child : out.get(node)) {
                    inCount.minus1(child);
                    if (inCount.get(child) == 0) {
                        queue.offer(child);
                    }
                }
                if (target.containsKey(node)) {
                    ans.add(target.get(node));
                }
            }

            return ans;
        }

        class ToIntMap<T> {

            Map<T, Integer> map = new HashMap<>();

            public int getIndex(T t) {
                return map.computeIfAbsent(t, x -> map.size());
            }
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

        static class Counter<K> {

            private Map<K, IntValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

            public final static IntValue NUM_0 = new IntValue();

            public int plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
            }

            public int minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                    return val.value;
                }
                return 0;
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }

            public List<Integer> values() {
                List<Integer> list = new ArrayList<>(counter.size());
                for (IntValue val : counter.values()) {
                    list.add(val.value);
                }
                return list;
            }

            public List<Count<K>> keysAndVals() {
                List<Count<K>> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Count<K>(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

        }

        static class Count<K> {
            K key;
            int count;

            public Count(K key, int count) {
                super();
                this.key = key;
                this.count = count;
            }
        }

        static class IntValue {
            int value = 0;
        }
    }

}
