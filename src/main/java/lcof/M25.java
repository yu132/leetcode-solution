package lcof;

import model.ListNode;

/**  
 * @ClassName: M25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M25 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode node = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    node      = node.next;
                    l1        = l1.next;
                } else {
                    node.next = l2;
                    node      = node.next;
                    l2        = l2.next;
                }
            }
            if (l1 != null) {
                node.next = l1;
            } else {
                node.next = l2;
            }
            return head.next;
        }
    }

}
