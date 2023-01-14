package old._0400_0499;

import java.util.HashMap;
import java.util.HashSet;

/**  
 * @ClassName: _432  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月22日  
 *  
 */
public class _432 {

    class AllOne {

        class Node {
            Node before;
            Node next;

            int value;

            HashSet<String> set = new HashSet<>();

            public Node(int value) {
                super();
                this.value = value;
            }
        }

        Node head;

        HashMap<Integer, Node> valueNodemap = new HashMap<>();
        HashMap<String, Integer> keyValuemap = new HashMap<>();

        /** Initialize your data structure here. */
        public AllOne() {
            head        = new Node(0);
            head.before = head;
            head.next   = head;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            int value = keyValuemap.getOrDefault(key, 0) + 1;
            keyValuemap.put(key, value);

            if (value == 1) {
                Node node = valueNodemap.get(1);
                if (node == null) {// 为1的节点根本就没有
                    node = new Node(1);
                    valueNodemap.put(1, node);
                    head.next.before = node;
                    node.before      = head;
                    node.next        = head.next;
                    head.next        = node;
                }
                node.set.add(key);
            } else {
                Node node = valueNodemap.get(value - 1);

                if (node.next.value != value) {// 下一个节点的值不是value
                    Node newNode = new Node(value);
                    node.next.before = newNode;
                    newNode.before   = node;
                    newNode.next     = node.next;
                    node.next        = newNode;
                    valueNodemap.put(value, newNode);
                }

                node.next.set.add(key);

                node.set.remove(key);
                if (node.set.size() == 0) {// 删除之前的元素之后该节点没有元素了
                    node.before.next = node.next;
                    node.next.before = node.before;
                    valueNodemap.remove(value - 1);
                }
            }

        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            int value = keyValuemap.getOrDefault(key, 0) - 1;
            if (value == -1) {
                return;
            }
            keyValuemap.put(key, value);

            Node node = valueNodemap.get(value + 1);

            if (value != 0) {
                if (node.before.value != value) {// 上一个节点的值不是value
                    Node newNode = new Node(value);
                    node.before.next = newNode;
                    newNode.before   = node.before;
                    newNode.next     = node;
                    node.before      = newNode;
                    valueNodemap.put(value, newNode);
                }
                node.before.set.add(key);
            }

            node.set.remove(key);
            if (node.set.size() == 0) {// 删除之前的元素之后该节点没有元素了
                node.before.next = node.next;
                node.next.before = node.before;
                valueNodemap.remove(value + 1);
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (head.next == head) {
                return "";
            }
            return head.before.set.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (head.next == head) {
                return "";
            }
            return head.next.set.iterator().next();
        }

        public void print() {
            Node node = head.next;
            while (node != head) {
                System.out.println(node.set);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        AllOne a = new _432().new AllOne();
        a.inc("a");

        a.inc("b");
        a.inc("b");
        a.inc("b");
        a.inc("b");

        a.dec("b");
        a.dec("b");

        System.out.println(a.getMaxKey());
        System.out.println(a.getMinKey());
    }

    /**
     * 
     * a 1
     * b 2
     * 
     */
}
