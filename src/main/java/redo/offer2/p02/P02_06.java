package redo.offer2.p02;

import model.ListNode;

/**  
 * @ClassName: P02_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P02_06 {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode back = reverse(slow.next), forward = head;
            while (back != null) {
                if (forward.val != back.val) {
                    return false;
                }
                back = back.next;
                forward = forward.next;
            }
            return true;
        }

        public ListNode reverse(ListNode node) {
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

}
