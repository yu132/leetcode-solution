package reredo;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P0146  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0146 {

    class LRUCache {

        Node head = new Node(-1, -1), tail = new Node(-1, -1);

        Map<Integer, Node> map = new HashMap<>();

        int cap;

        public LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            updateNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                updateNode(node);
                node.val = value;
            } else {
                if (map.size() == cap) {
                    Node toRemove = head.next;
                    removeSelf(toRemove);
                    map.remove(toRemove.key);
                }
                Node node = new Node(key, value);
                map.put(key, node);
                appendPrev(tail, node);
            }
        }

        void removeEldest() {
            removeSelf(head.next);
        }

        void updateNode(Node node) {
            removeSelf(node);
            appendPrev(tail, node);
        }

        void appendPrev(Node node, Node toappend) {
            toappend.prev = node.prev;
            toappend.next = node;
            node.prev.next = toappend;
            node.prev = toappend;
        }

        void removeSelf(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        class Node {
            int key, val;
            Node prev, next;

            public Node(int key, int val) {
                super();
                this.key = key;
                this.val = val;
            }
        }
    }

}
