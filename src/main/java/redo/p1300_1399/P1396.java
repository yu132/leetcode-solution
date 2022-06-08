package redo.p1300_1399;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P1396  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1396 {

    static//

    class UndergroundSystem {

        Counter<String> totalTime = new Counter<>();
        Map<Integer, CheckIn> checkIn = new HashMap<>();

        public UndergroundSystem() {}

        public void checkIn(int id, String stationName, int t) {
            checkIn.put(id, new CheckIn(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckIn checkIn = this.checkIn.get(id);
            String pair = checkIn.stationName + " " + stationName;
            totalTime.plus1Count(pair);
            totalTime.add(pair, t - checkIn.time);
        }

        public double getAverageTime(String startStation, String endStation) {
            IntValue v = totalTime.counter.get(startStation + " " + endStation);
            return (double)v.value / v.count;
        }

        static class CheckIn {
            String stationName;
            int time;

            public CheckIn(String stationName, int time) {
                super();
                this.stationName = stationName;
                this.time = time;
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

            public void plus1Count(K key) {
                ++counter.computeIfAbsent(key, (x) -> new IntValue()).count;
            }

            public void plus1(K key) {
                ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
            }

            public void minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                }
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }

        }

        static class IntValue {
            int value = 0;
            int count = 0;
        }
    }



}
