package lcci.M03;

/**  
 * @ClassName: M03_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月27日  
 *  
 */
public class M03_02 {

    class MinStack {

        private class Node {
            int value;
            int min;
            Node next;

            public Node(int value, int min) {
                super();
                this.value = value;
                this.min   = min;
            }
        }

        private Node head = new Node(0, 0);

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int x) {
            Node n = new Node(x, Math.min(x, head.next == null ? Integer.MAX_VALUE : head.next.min));
            n.next    = head.next;
            head.next = n;
        }

        public void pop() {
            if (head.next != null) {
                head.next = head.next.next;
            }
        }

        public int top() {
            if (head.next != null) {
                return head.next.value;
            }
            return -1;
        }

        public int getMin() {
            if (head.next != null) {
                return head.next.min;
            }
            return -1;
        }
    }

}
