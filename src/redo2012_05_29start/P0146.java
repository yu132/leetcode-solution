package redo2012_05_29start;

import java.util.HashMap;

/**  
 * @ClassName: P0146  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月29日  
 *  
 */
public class P0146 {

    static//

    class LRUCache {

        HashMap<Integer, Node> nodeMap = new HashMap<>();

        Node head, tail;

        int maxSize;

        static class Node {
            Node next, prev;

            int key, val;

            public Node(int key, int val) {
                super();
                this.key = key;
                this.val = val;
            }

            void removeSelf() {
                next.prev = prev;
                prev.next = next;
            }

            void insertAfter(Node node) {
                node.next = next;
                node.prev = this;
                next.prev = node;
                next = node;
            }
        }

        public LRUCache(int capacity) {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;

            maxSize = capacity;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) {
                return -1;
            }
            return updateKey(key).val;
        }

        private Node updateKey(int key) {
            Node node = nodeMap.get(key);
            node.removeSelf();
            head.insertAfter(node);
            return node;
        }

        public void put(int key, int value) {
            if (nodeMap.containsKey(key)) {
                updateKey(key).val = value;
                return;
            }
            if (nodeMap.size() == maxSize) {
                Node toRemove = tail.prev;
                toRemove.removeSelf();
                nodeMap.remove(toRemove.key);
            }

            Node node = new Node(key, value);
            head.insertAfter(node);
            nodeMap.put(key, node);
            return;
        }
    }

}
