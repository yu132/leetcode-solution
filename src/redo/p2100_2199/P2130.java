package redo.p2100_2199;

import model.ListNode;

public class P2130 {

    class Solution {
        public int pairSum(ListNode head) {
            ListNode tail = reverseLastHalf(head);
            int max = 0;
            while (head != null) {
                max = Math.max(max, head.val + tail.val);
                head = head.next;
                tail = tail.next;
            }
            return max;
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

        ListNode halfEvenLeft(ListNode head) {
            ListNode slow = head, fast = head, prevSlow = null;
            while (fast != null) {
                prevSlow = slow;
                slow = slow.next;
                fast = next(fast.next);
            }
            return prevSlow;
        }

        ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }

        // 将后半链表反转，通常用于双向链表遍历
        ListNode reverseLastHalf(ListNode node) {
            ListNode halfLeft = halfEvenLeft(node), halfRight = halfLeft.next;
            halfLeft.next = null;
            return reverse(halfRight);
        }
    }

}
