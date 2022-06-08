package reredo.rrrd;

import model.ListNode;

/**  
 * @ClassName: P25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月25日  
 *  
 */
public class P25 {

    static//

    class Solution {

        private final static ListNode NULL = new ListNode(-1);

        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode dummy = new ListNode(-1), node = dummy;

            while (true) {
                ListNode nextk = nextK(head, k);
                if (nextk == null) {
                    node.next = head;
                    break;
                }
                node.next = reverse(head);
                node = head;
                head = nextk;
                if (nextk == NULL) {
                    break;
                }
            }

            return dummy.next;
        }

        ListNode nextK(ListNode node, int k) {
            while (--k != 0 && node.next != null) {
                node = node.next;
            }
            if (node.next == null) {
                if (k == 0) {
                    return NULL;
                } else {
                    return null;
                }
            }

            ListNode nextk = node.next;
            node.next = null;
            return nextk;
        }

        ListNode reverse(ListNode head) {
            ListNode dummy = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = next;
            }
            return dummy.next;
        }
    }

}
