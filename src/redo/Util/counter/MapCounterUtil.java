package redo.Util.counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: MapCounterUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class MapCounterUtil {

    public static <K> int maxCount(Counter<K> counter) {
        int max = Integer.MIN_VALUE;
        for (IntValue value : counter.counter.values()) {
            max = Math.max(max, value.value);
        }
        return max;
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
