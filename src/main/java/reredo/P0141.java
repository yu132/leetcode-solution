package reredo;

import model.ListNode;

/**  
 * @ClassName: P0141  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0141 {

    public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode slow = next(head), fast = next(next(head));

            while (slow != fast && fast != null) {
                slow = next(slow);
                fast = next(next(fast));
            }

            return fast != null;
        }

        ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }
    }

}
