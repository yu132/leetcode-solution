package redo.p1700_1799;

import model.ListNode;

public class P1721 {

    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode lastK = lastK(head, k), nextK = nextK(head, k - 1);
            int val = lastK.val;
            lastK.val = nextK.val;
            nextK.val = val;
            return head;
        }

        //返回倒数第k个节点，必须保证k小于链表长度
        ListNode lastK(ListNode head, int k) {
            ListNode fast = head, slow = head;
            fast = nextK(fast, k);
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        ListNode nextK(ListNode head, int k) {
            ListNode fast = head;
            while (fast != null && k-- != 0) {
                fast = fast.next;
            }
            return fast;
        }
    }

}
