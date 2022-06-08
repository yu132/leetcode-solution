package redo.p0000_0099;

import model.ListNode;

/**  
 * @ClassName: P25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P25 {

    static//

    class Solution {

        final static ListNode NULL = new ListNode(-1);

        public ListNode reverseKGroup(ListNode head, int k) {

            ListNode fakeHead = new ListNode(-1), node = fakeHead;

            while (head != NULL) {
                ListNode last = head, next = nextK(head, k);
                if (next == null) {// 本组不足k个，直接接上退出
                    node.next = head;
                    break;
                }
                node.next = reverseK(head, k);
                node = last;
                head = next;
            }
            return fakeHead.next;
        }

        public ListNode nextK(ListNode node, int k) {
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

}
