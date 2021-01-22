package redo.Util.ds.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**  
 * @ClassName: TrieLikedTree  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class TrieLikedTree {

    static class DisorderlyTrie<T extends Comparable<T>> {

        DisorderlyTrieNode<T> head = new DisorderlyTrieNode<>(null);

        public void add(List<T> vals) {
            DisorderlyTrieNode<T> node = head;
            for (T val : vals) {
                node.children.putIfAbsent(val, new DisorderlyTrieNode<>(val));
                node = node.children.get(val);
            }
            node.isPrefix = false;
        }
    }

    static class DisorderlyTrieNode<T> {
        T val;
        boolean isPrefix = true;
        Map<T, DisorderlyTrieNode<T>> children = new HashMap<>();

        public DisorderlyTrieNode(T val) {
            super();
            this.val = val;
        }
    }

    static class OrderlyTrie<T extends Comparable<T>> {

        OrderlyTrieNode<T> head = new OrderlyTrieNode<>(null);

        public void add(List<T> vals) {
            OrderlyTrieNode<T> node = head;
            for (T val : vals) {
                node.children.putIfAbsent(val, new OrderlyTrieNode<>(val));
                node = node.children.get(val);
            }
            node.isPrefix = false;
        }
    }

    static class OrderlyTrieNode<T extends Comparable<T>> {
        T val;
        boolean isPrefix = true;
        TreeMap<T, OrderlyTrieNode<T>> children = new TreeMap<>();

        public OrderlyTrieNode(T val) {
            super();
            this.val = val;
        }
    }

}
