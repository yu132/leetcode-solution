package redo2012_05_29start;

import model.ListNode;

/**  
 * @ClassName: P0025  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0025 {

    class Solution {

        ListNode NULL = new ListNode(-1);

        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1), node = dummy;
            while (head != null) {
                ListNode nextK = nextK(head, k);
                if (nextK == NULL) {
                    node.next = head;
                    return dummy.next;
                }
                ListNode reverseList = reverseK(head, k);
                node.next = reverseList;
                node = head;
                head = nextK;
            }
            return dummy.next;
        }

        ListNode reverseK(ListNode node, int k) {
            ListNode dummy = new ListNode(-1);
            while (k-- != 0) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
            }
            return dummy.next;
        }

        ListNode nextK(ListNode node, int k) {
            while (k-- != 0) {
                if (node == null) {
                    return NULL;
                }
                node = node.next;
            }
            return node;
        }
    }

}
