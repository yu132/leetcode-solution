package redo.p2800_2899;

import model.ListNode;

public class P2816 {

    class Solution {
        public ListNode doubleIt(ListNode head) {
            ListNode node = reverse(head);
            ListNode temp = node;
            int adv = 0;
            while (node != null) {
                int now = node.val * 2 + adv;
                node.val = now % 10;
                adv = now / 10;
                if (node.next == null && adv != 0) {
                    node.next = new ListNode(1);
                    break;
                }
                node = node.next;
            }
            return reverse(temp);
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
