package redo.Util.listAndArr;

import model.ListNode;

/**
 * @author 余定邦
 * @ClassName: LinkedLists
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月19日
 */
public class LinkedLists {

    int len(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
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

    /* 链表折半，已知链表长度为奇数
     * 1 - 2 - 3 - 4 - 5
     *         ^
     */
    ListNode halfOdd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /* 链表折半，已知链表长度为偶数
     * 1 - 2 - 3 - 4 - 5 - 6
     *             ^
     */
    ListNode halfEvenRight(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = next(fast.next);
        }
        return slow;
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

    // 将后半链表反转，通常用于双向链表遍历，会将前半中间处截断并反转
    ListNode reverseLastHalf(ListNode node) {
        ListNode halfLeft = halfEvenLeft(node), halfRight = halfLeft.next;
        halfLeft.next = null;
        return reverse(halfRight);
    }

    int get(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }


}
