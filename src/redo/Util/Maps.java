package redo.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static class ListMap<K, E> {

        Map<K, List<E>> map = new HashMap<>();

        public void add(K key, E element) {
            map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
        }

        public void remove(K key, E element) {
            map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
        }

        public List<E> get(K key) {
            return map.getOrDefault(key, Collections.emptyList());
        }

    }

}
