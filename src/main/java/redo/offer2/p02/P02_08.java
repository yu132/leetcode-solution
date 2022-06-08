package redo.offer2.p02;

import model.ListNode;

/**  
 * @ClassName: P02_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P02_08 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head, fast = slow;
            do {
                slow = next(slow);
                fast = next(next(fast));
            } while (fast != null && slow != fast);

            if (fast == null) {
                return null;
            }

            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        public ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }
    }

}
