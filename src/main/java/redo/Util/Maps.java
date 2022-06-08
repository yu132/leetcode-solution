package redo.Util;

import java.util.*;

/**
 * @author 余定邦
 * @ClassName: Maps
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月27日
 */
public class Maps {

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

    class SetMap<K, E> {

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

    class LinkedListMap<K, E> {

        Map<K, LinkedList<E>> map = new HashMap<>();

        public void addFirst(K key, E element) {
            get(key).addFirst(element);
        }

        public void addLast(K key, E element) {
            get(key).addLast(element);
        }

        public E removeFirst(K key) {
            return get(key).removeFirst();
        }

        public E removeLast(K key) {
            return get(key).removeLast();
        }

        public void remove(K key, E element) {
            get(key).remove(element);
        }

        public LinkedList<E> get(K key) {
            return map.computeIfAbsent(key, (x) -> new LinkedList<>());
        }

    }

    /**
     * 将任意东西编码成数字的map
     */
    class ToIntMap<T> {

        Map<T, Integer> map = new HashMap<>();

        public int index(T t) {
            return map.computeIfAbsent(t, x -> map.size());
        }
    }

}
