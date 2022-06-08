package redo.p2100_2199;

import java.util.*;

public class P2131 {

    static
    class Solution {
        public int longestPalindrome(String[] words) {
            Counter<String> counter = new Counter<>();

            int selfPalindrome = 0, pair = 0;

            for (String word : words) {
                String reverse = "" + word.charAt(1) + word.charAt(0);
                if (counter.get(reverse) != 0) {
                    counter.minus1(reverse);
                    pair += 2;
                    if (word.equals(reverse)) {
                        selfPalindrome -= 1;
                    }
                } else {
                    counter.plus1(word);
                    if (word.equals(reverse)) {
                        selfPalindrome += 1;
                    }
                }
            }

            return (pair + Math.min(selfPalindrome, 1)) * 2;
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
