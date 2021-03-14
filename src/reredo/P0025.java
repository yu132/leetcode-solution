package reredo;

import model.ListNode;

/**  
 * @ClassName: P0025  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0025 {

    class Solution {

        ListNode NULL = new ListNode(-1);

        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode dummy = new ListNode(-1), node = dummy;

            while (true) {
                ListNode nextK = nextK(head, k);
                if (nextK == null) {
                    node.next = head;
                    break;
                }
                ListNode tail = head;
                node.next = reverse(head, k);
                node = tail;
                head = nextK;
                if (nextK == NULL) {
                    break;
                }
            }

            return dummy.next;
        }

        ListNode nextK(ListNode head, int k) {
            while (k-- != 0 && head != null) {
                head = head.next;
            }
            if (k == -1 && head == null) {
                return NULL;
            }
            return head;
        }

        ListNode reverse(ListNode node, int k) {
            ListNode dummy = new ListNode(-1);
            while (k-- != 0) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
            }
            return dummy.next;
        }
    }

}
