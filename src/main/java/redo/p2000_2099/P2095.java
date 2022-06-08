package redo.p2000_2099;

import model.ListNode;

public class P2095 {

    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode slow = dummy, fast = dummy;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }

        ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }
    }

}
