package redo2012_07_25start;

import model.ListNode;

/**  
 * @ClassName: P25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月25日  
 *  
 */
public class P25 {

    class Solution {

        ListNode NOT_ENOUGH = new ListNode(-1);

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode nextK, dummy = new ListNode(-3), node = dummy;

            while (null != head) {
                nextK = nextK(head, k);
                if (NOT_ENOUGH == nextK) {
                    node.next = head;
                    break;
                }
                node.next = reverse(head, k);
                node = head;
                head = nextK;
            } ;

            return dummy.next;
        }

        ListNode nextK(ListNode node, int k) {
            while (null != node && k != 0) {
                node = node.next;
                --k;
            }
            if (k == 0) {
                return node;
            }
            return NOT_ENOUGH;
        }

        ListNode reverse(ListNode node, int k) {
            ListNode dummy = new ListNode(-2);
            while (k != 0) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
                --k;
            }
            return dummy.next;
        }
    }

}
