package test.a;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**  
 * @ClassName: LRU  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月29日  
 *  
 */
public class LRU<K, V> {

    private Node<K, V> head = new Node<K, V>(null, null),
        tail = new Node<K, V>(null, null);

    private Map<K, Node<K, V>> map = new HashMap<>();

    private int size;

    public LRU(int size) {
        super();
        head.next = tail;
        tail.prev = head;
        this.size = size;
    }

    public void set(K key, V val) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.val = val;
            updateNode(node);
        } else {
            if (map.size() == size) {
                Node<K, V> toRemove = tail.prev;
                toRemove.removeSelf();
                map.remove(toRemove.key);
            }
            Node<K, V> node = new Node<K, V>(key, val);
            map.put(key, node);
            head.appendNext(node);
        }
    }

    public Optional<V> get(K key) {
        if (!map.containsKey(key)) {
            return Optional.empty();
        }
        Node<K, V> node = map.get(key);
        updateNode(node);
        return Optional.of(node.val);
    }

    private void updateNode(Node<K, V> node) {
        node.removeSelf();
        head.appendNext(node);
    }


    static class Node<K, V> {
        Node<K, V> prev, next;
        K key;
        V val;

        public Node(K key, V val) {
            super();
            this.key = key;
            this.val = val;
        }

        void removeSelf() {
            prev.next = next;
            next.prev = prev;
        }

        void appendNext(Node<K, V> node) {
            node.next = next;
            node.prev = this;
            next.prev = node;
            next = node;
        }
    }



}
