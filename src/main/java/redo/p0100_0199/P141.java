package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P141  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P141 {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode fast = head, slow = head;
            do {
                fast = next(next(fast));
                slow = next(slow);
                if (fast == null) {
                    return false;
                }
            } while (fast != slow);
            return true;
        }

        private ListNode next(ListNode head) {
            if (head == null) {
                return null;
            }
            return head.next;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertTrue(s.hasCycle(LinkedListTestUtil.buildCycle(2, 3, 2, 0, -4)));
        assertTrue(s.hasCycle(LinkedListTestUtil.buildCycle(1, 1, 2)));
        assertTrue(!s.hasCycle(LinkedListTestUtil.build(1, 1, 2)));
        assertTrue(!s.hasCycle(LinkedListTestUtil.build()));
    }

}
