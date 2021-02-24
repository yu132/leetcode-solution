package redo.p0100_0199;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P143  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P143 {

    class Solution {
        public void reorderList(ListNode head) {

            if (head == null || head.next == null) {
                return;
            }

            ListNode[] parts = half(head);
            parts[1] = reverse(parts[1]);
            merge(parts[0], parts[1]);
        }

        ListNode[] half(ListNode node) {

            ListNode slow = node, fast = node;

            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode p2 = slow.next;
            slow.next = null;

            return new ListNode[] {node, p2};
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

        ListNode merge(ListNode node1, ListNode node2) {
            ListNode head = new ListNode(-1), n = head;
            boolean flag = true;
            for (; node1 != null || node2 != null; flag = !flag, n = n.next) {
                if (flag) {
                    n.next = node1;
                    node1 = node1.next;
                } else {
                    n.next = node2;
                    node2 = node2.next;
                }
            }
            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        s.reorderList(LinkedListTestUtil.build(1, 2, 3, 4, 5));
    }
}
