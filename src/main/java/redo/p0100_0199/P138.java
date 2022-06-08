package redo.p0100_0199;

/**  
 * @ClassName: P138  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P138 {

    class Solution {
        public Node copyRandomList(Node head) {

            if (head == null) {
                return null;
            }

            Node node = head;
            while (node != null) {
                appendSameNext(node);
                node = node.next.next;
            }
            node = head.next;
            while (node.next != null) {
                node.random = node.random != null ? node.random.next : null;
                node = node.next.next;
            }
            node.random = node.random != null ? node.random.next : null;

            Node ret = head.next;

            node = head;
            while (node != null) {
                Node next = node.next.next;
                node.next.next = next != null ? next.next : null;
                node.next = next;
                node = next;
            }
            return ret;
        }

        void appendSameNext(Node node) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            copy.random = node.random;
            node.next = copy;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
