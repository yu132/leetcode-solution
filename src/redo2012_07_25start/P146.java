package redo2012_07_25start;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**  
 * @ClassName: P146  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月25日  
 *  
 */
public class P146 {

    class LRUCache {

        class Node {
            int key, val;

            Node next, prev;

            public Node(int key, int val) {
                super();
                this.key = key;
                this.val = val;
            }

            void addNext(Node node) {
                node.next = next;
                node.prev = this;
                next.prev = node;
                next = node;
            }

            void removeSelf() {
                next.prev = prev;
                prev.next = next;
            }
        }

        Map<Integer, Node> map = new HashMap<>();

        int capacity;

        Node head = new Node(-1, -1), tail = new Node(-1, -1);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            update(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
                update(node);
            } else {
                if (map.size() == capacity) {
                    Node toRemove = tail.prev;
                    toRemove.removeSelf();
                    map.remove(toRemove.key);
                }
                Node node = new Node(key, value);
                head.addNext(node);
                map.put(key, node);
            }
        }

        void update(Node node) {
            node.removeSelf();
            head.addNext(node);
        }

    }

}
