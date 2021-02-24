package test;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: CC  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class CC {

    public class Solution {
        public void reorderList(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode rev = reverse(slow);
            ListNode hh = new ListNode(-1), node = hh;
            while (head != rev && rev != null) {
                node.next = head;
                head = head.next;

                node.next.next = rev;
                rev = rev.next;

                node = node.next.next;
            }
            if (head == rev) {
                node.next = head;
            }
        }

        ListNode reverse(ListNode node) {
            ListNode head = new ListNode(-1);
            while (node != null) {
                ListNode next = node.next;
                node.next = head.next;
                head.next = node;
                node = next;
            }
            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        ListNode head = LinkedListTestUtil.build(1, 2, 3, 4);
        s.reorderList(head);
        Assert.assertEquals("[1,4,2,3]", head.toString());
    }

}
