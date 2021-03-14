package reredo;

import model.ListNode;

/**  
 * @ClassName: P234  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0234 {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode half = reverse(half(head));

            while (head != null && half != null) {
                if (head.val != half.val) {
                    return false;
                }
                head = head.next;
                half = half.next;
            }

            return true;
        }

        ListNode half(ListNode node) {
            ListNode slow = node, fast = node.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode ret = slow.next;
            slow.next = null;
            return ret;
        }

        ListNode reverse(ListNode node) {
            ListNode dummy = new ListNode(-1);
            while (node != null) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
            }
            return dummy.next;
        }
    }

}
