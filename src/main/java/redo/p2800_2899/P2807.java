package redo.p2800_2899;

import model.ListNode;

public class P2807 {

    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode node = head;
            while (node.next != null) {
                ListNode gcd = new ListNode(gcd(node.val, node.next.val));
                gcd.next = node.next;
                node.next = gcd;
                node = node.next.next;
            }
            return head;
        }

        public int gcd(int m, int n) {
            int r;
            while (n > 0) {
                r = m % n;
                m = n;
                n = r;
            }
            return m;
        }
    }

}
