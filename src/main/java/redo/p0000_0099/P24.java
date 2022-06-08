package redo.p0000_0099;

import model.ListNode;

/**  
 * @ClassName: P24  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P24 {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node1 = head, node2 = head.next, next = node2.next;
            node2.next = node1;
            node1.next = swapPairs(next);
            return node2;
        }
    }

}
