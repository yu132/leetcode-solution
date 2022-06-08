package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P876  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P876 {

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = next(head);
            while (fast != null) {
                slow = next(slow);
                fast = next(next(fast));
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



    @Test
    public void test() {
        Solution s = new Solution();
        ListNode head = LinkedListTestUtil.build(1, 2, 3, 4, 5);
        Assert.assertEquals(LinkedListTestUtil.get(3, head), s.middleNode(head));

        head = LinkedListTestUtil.build(1, 2, 3, 4, 5, 6);
        Assert.assertEquals(LinkedListTestUtil.get(4, head), s.middleNode(head));
    }

}
