package redo2012_05_29start;

import model.ListNode;

/**  
 * @ClassName: P0141  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月30日  
 *  
 */
public class P0141 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = next(head), fast = next(next(head));
            while (fast != null && slow != fast) {
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
