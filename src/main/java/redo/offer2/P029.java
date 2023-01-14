package redo.offer2;


public class P029 {

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                Node node = new Node(insertVal);
                node.next = node;
                return node;
            }
            if (head.next == head) {
                Node node = new Node(insertVal);
                head.next = node;
                node.next = head;
                return head;
            }
            Node h1 = head, t1 = null, h2 = null, t2 = null;
            Node node = head;
            do {
                if (node.next.val < node.val) {
                    t1 = node;
                    h2 = node.next;
                    break;
                }
                node = node.next;
            } while (node.next != head);

            t2 = node;
            Node hh = null, tt = null;
            if (h2 == null) {
                hh = h1;
                tt = node;
                tt.next = null;
            } else {
                hh = h2;
                t2.next = h1;
                t1.next = null;
                tt = t1;
            }
            hh = insertOrderly(hh, insertVal);

            Node ttt = hh;
            while (ttt.next != null) {
                ttt = ttt.next;
            }
            ttt.next = hh;
            return head;
        }

        //插入有序链表，保证插入后依然有序
        Node insertOrderly(Node head, int val) {
            if (val < head.val) {
                Node node = new Node(val);
                node.next = head;
                return node;
            }
            boolean inserted = false;
            Node hh = head;
            while (head.next != null) {
                if (head.val <= val && val < head.next.val) {
                    insertAfter(head, val);
                    inserted = true;
                    break;
                }
                head = head.next;
            }
            if (!inserted) {
                insertAfter(head, val);
            }
            return hh;
        }

        void insertAfter(Node node, int val) {
            Node newNode = new Node(val);
            newNode.next = node.next;
            node.next = newNode;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = node;
        new P029().new Solution().insert(node, 0);
    }

    ;

}
