package redo.p2400_2499;

import model.ListNode;

public class P2487 {

    class Solution {
        public ListNode removeNodes(ListNode head) {
            ListNode reverse = reverse(head), node = reverse;
            while (node.next != null) {
                if (node.next.val < node.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return reverse(reverse);
        }

        ListNode reverse(ListNode node) {
            ListNode dummy = new ListNode(-1);
            while (node != null) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
            }
            return dummy.next;
        }
    }

}
