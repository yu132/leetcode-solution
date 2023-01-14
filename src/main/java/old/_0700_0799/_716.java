package old._0700_0799;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

/**  
 * @ClassName: _716  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _716 {

    class MaxStack {

        class Node {
            int val;
            Node before;
            Node next;

            public Node(int val) {
                super();
                this.val = val;
            }
        }

        Node head;

        TreeMap<Integer, ArrayList<Node>> tree = new TreeMap<>();

        /** initialize your data structure here. */
        public MaxStack() {
            head        = new Node(0);
            head.before = head;
            head.next   = head;
        }

        public void push(int x) {
            Node n = new Node(x);
            n.next           = head.next;
            n.before         = head;
            head.next.before = n;
            head.next        = n;

            ArrayList<Node> list = tree.getOrDefault(x, new ArrayList<>());
            list.add(n);

            tree.put(x, list);
        }

        public int pop() {

            int val = head.next.val;

            head.next.next.before = head;
            head.next             = head.next.next;

            ArrayList<Node> list = tree.get(val);
            list.remove(list.size() - 1);

            if (list.size() == 0) {
                tree.remove(val);
            }

            return val;
        }

        public int top() {
            return head.next.val;
        }

        public int peekMax() {
            return tree.lastKey();
        }

        public int popMax() {
            Entry<Integer, ArrayList<Node>> entry = tree.lastEntry();

            int                             val   = entry.getKey();
            ArrayList<Node>                 list  = entry.getValue();

            Node                            n     = list.remove(list.size() - 1);
            n.next.before = n.before;
            n.before.next = n.next;

            if (list.size() == 0) {
                tree.remove(val);
            }

            return val;
        }
    }

}
