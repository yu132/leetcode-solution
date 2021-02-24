package redo.p0000_0099;

import model.ListNode;

/**  
 * @ClassName: P61  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P61 {

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || k == 0) {
                return head;
            }

            int len = len(head);

            k %= len;

            if (k == 0 || len == 1) {
                return head;
            }

            ListNode slow = head, fast = head;

            while (k-- != 0) {
                fast = fast.next;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode p1s = head, p1e = slow, p2s = slow.next, p2e = fast;

            p2e.next = p1s;
            p1e.next = null;

            return p2s;
        }

        int len(ListNode head) {
            int len = 0;
            while (head != null) {
                ++len;
                head = head.next;
            }
            return len;
        }
    }

}
