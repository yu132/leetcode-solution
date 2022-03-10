package redo.p2100_2199;

import model.ListNode;

public class P2181 {

    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode(0), node = dummy;
            head = head.next;
            int count = 0;
            while (null != head) {
                if (0 == head.val) {
                    node.next = new ListNode(count);
                    node = node.next;
                    count = 0;
                } else {
                    count += head.val;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }

}
