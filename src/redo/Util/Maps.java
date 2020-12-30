package redo.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: Maps  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class Maps {

    static class Counter<K> {

        private Map<K, IntValue> counter = new HashMap<>();

        public final static IntValue NUM_0 = new IntValue();

        public void plus1(K key) {
            ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
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
    }

}
