package lcof;

import model.ListNode;

/**  
 * @ClassName: M18  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M18 {

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            if (head.val == val) {
                return head.next;
            }
            ListNode node = head;
            while (node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                    return head;
                }
                node = node.next;
            }
            return head;
        }
    }

}
