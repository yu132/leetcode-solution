package redo.p2400_2499;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class P2434 {

    class Solution {
        public String robotWithString(String s) {
            OrderCounter<Character> counter = new OrderCounter<>();
            StringBuilder buf = new StringBuilder(s.length());
            Deque<Character> stack = new ArrayDeque<>(s.length());
            for (char ch : s.toCharArray()) {
                counter.plus1(ch);
            }
            for (char ch : s.toCharArray()) {
                stack.push(ch);
                counter.minus1(ch);
                while (!stack.isEmpty() && !counter.counter.isEmpty() && stack.peek() <= counter.minKey()) {
                    char temp = stack.pop();
                    buf.append(temp);
                }
            }
            while (!stack.isEmpty()) {
                buf.append(stack.pop());
            }

            return buf.toString();
        }

        class OrderCounter<K extends Comparable<K>> {
            private TreeMap<K, IntValue> counter = new TreeMap<>();

            public final IntValue NUM_0 = new IntValue();

            public OrderCounter() {
            }

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

            public K minKey() {
                return counter.firstKey();
            }

            public K maxKey() {
                return counter.lastKey();
            }

            class IntValue {
                int value = 0;
            }
        }
    }

    public static void main(String[] args) {
        new P2434().new Solution().robotWithString("zza");
    }

}
