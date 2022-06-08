package reredo;

import model.ListNode;

/**  
 * @ClassName: P0142  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0142 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode slow = next(head), fast = next(next(head));

            for (; slow != fast && fast != null;) {
                fast = next(next(fast));
                slow = next(slow);
            }

            if (fast == null) {
                return null;
            }

            fast = head;

            for (; slow != fast;) {
                fast = next(fast);
                slow = next(slow);
            }

            return slow;
        }

        ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }
    }

}
