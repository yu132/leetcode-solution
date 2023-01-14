package redo.Util.listAndArr;

import model.ListNode;

/**
 * @author 余定邦
 * @ClassName: LinkedLists
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月19日
 */
public class LinkedLists {

    //插入有序链表，保证插入后依然有序
    ListNode insertOrderly(ListNode head, int val) {
        if (val < head.val) {
            ListNode node = new ListNode(val);
            node.next = head;
            return node;
        }
        boolean inserted = false;
        ListNode hh = head;
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

    void insertAfter(ListNode node, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
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

    ListNode NULL = new ListNode(0);

    public ListNode nextKs(ListNode node, int k) {
        while (node != null && k-- != 0) {
            node = node.next;
        }
        if (node != null) {
            return node;
        }
        if (k == 0) {// 没有下一组但是本组还足k个，依然要反转
            return NULL;
        }
        return null;
    }

    public ListNode reverseK(ListNode node, int k) {
        ListNode head = new ListNode(-1);
        while (k-- != 0) {
            ListNode next = node.next;
            node.next = head.next;
            head.next = node;
            node = next;
        }
        return head.next;
    }

}
