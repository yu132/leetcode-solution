package redo.p0100_0199;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**  
 * @ClassName: P146  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P146 {

    class LRUCache {

        LinkedHashMap<Integer, Integer> lru;

        public LRUCache(int capacity) {
            lru = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
                private static final long serialVersionUID = 1L;

                @Override
                protected boolean
                    removeEldestEntry(Entry<Integer, Integer> eldest) {
                    return this.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return lru.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            lru.put(key, value);
        }
    }

}
