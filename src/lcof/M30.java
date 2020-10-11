package lcof;

/**  
 * @ClassName: M30  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月18日  
 *  
 */
public class M30 {

    class MinStack {

        class Node {
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                super();
                this.val = val;
                this.min = min;
            }
        }

        private Node head = new Node(0, 0);

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int x) {
            int  min  = head.next == null ? x : Math.min(x, head.next.min);
            Node node = new Node(x, min);
            node.next = head.next;
            head.next = node;
        }

        public void pop() {
            head.next = head.next.next;
        }

        public int top() {
            return head.next.val;
        }

        public int min() {
            return head.next.min;
        }
    }

}
