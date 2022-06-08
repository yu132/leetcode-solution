package redo.p2000_2099;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P2034 {

    class StockPrice {

        TreeMap<Integer, IntValue> orderedMap = new TreeMap<>();
        int maxTimestamp = 0;
        Map<Integer, Integer> reverseMap = new HashMap<>();

        public StockPrice() {
        }

        public void update(int timestamp, int price) {
            maxTimestamp = Math.max(maxTimestamp, timestamp);
            if (reverseMap.containsKey(timestamp)) {
                int oldPrice = reverseMap.get(timestamp);
                IntValue value = orderedMap.get(oldPrice);
                --value.value;
                if (value.value == 0) {
                    orderedMap.remove(oldPrice);
                }
            }
            reverseMap.put(timestamp, price);
            orderedMap.computeIfAbsent(price, x -> new IntValue()).value++;
        }

        public int current() {
            return reverseMap.get(maxTimestamp);
        }

        public int maximum() {
            return orderedMap.lastKey();
        }

        public int minimum() {
            return orderedMap.firstKey();
        }

        class Node {
            int value, timestamp;

            public int getValue() {
                return value;
            }

            public Node(int value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        class IntValue {
            int value = 0;
        }
    }

}
