package redo.p0100_0199;

import model.ListNode;

/**  
 * @ClassName: P142  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P142 {

    public class Solution {

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return null;
            }
            ListNode slow = next(head), fast = next(next(head));
            while (slow != fast) {
                slow = next(slow);
                fast = next(next(fast));
            }
            fast = head;
            while (slow != fast) {
                slow = next(slow);
                fast = next(fast);
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
