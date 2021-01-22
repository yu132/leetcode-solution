package redo.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

    static class ListMap<K, E> {

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

    static class SetMap<K, E> {

        Map<K, Set<E>> map = new HashMap<>();

        public void add(K key, E element) {
            map.computeIfAbsent(key, (x) -> new HashSet<>()).add(element);
        }

        public void addAll(K key, Collection<E> elements) {
            map.computeIfAbsent(key, (x) -> new HashSet<>()).addAll(elements);
        }

        public void remove(K key, E element) {
            map.computeIfAbsent(key, (x) -> new HashSet<>()).remove(element);
        }

        public boolean contain(K key, E element) {
            return get(key).contains(element);
        }

        public Set<E> get(K key) {
            return map.getOrDefault(key, Collections.emptySet());
        }
    }

}
