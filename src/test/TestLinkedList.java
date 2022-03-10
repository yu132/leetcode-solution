package test;

/**  
 * @ClassName: TestLinkedList  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年9月8日  
 *  
 */
public class TestLinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            super();
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(0), node = head;

        for (int i = 1; i <= 7; ++i) {
            node.next = new Node(i);
            node = node.next;
        }

        head = reverse(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node reverse(Node node) {
        Node dummy = new Node(-1);
        while (node != null) {
            Node next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
        }
        return dummy.next;
    }


}
