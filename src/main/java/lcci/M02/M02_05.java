package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M02_05 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(0);
            ListNode node = head;
            int      acc  = 0;

            while (l1 != null && l2 != null) {
                node.next      = new ListNode(l1.val + l2.val + acc);
                acc            = node.next.val / 10;
                node.next.val %= 10;
                l1             = l1.next;
                l2             = l2.next;
                node           = node.next;
            }

            while (l1 != null) {
                node.next      = new ListNode(l1.val + acc);
                acc            = node.next.val / 10;
                node.next.val %= 10;
                l1             = l1.next;
                node           = node.next;
            }
            while (l2 != null) {
                node.next      = new ListNode(l2.val + acc);
                acc            = node.next.val / 10;
                node.next.val %= 10;
                l2             = l2.next;
                node           = node.next;
            }

            if (acc != 0) {
                node.next = new ListNode(acc);
            }

            return head.next;
        }
    }

}
