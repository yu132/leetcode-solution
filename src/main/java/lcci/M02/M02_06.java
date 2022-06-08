package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M02_06 {

    class Solution {
        public boolean isPalindrome(ListNode head) {

            ListNode node = head;

            int      len  = 0;

            while (node != null) {
                ++len;
                node = node.next;
            }

            int      half = len / 2;

            ListNode l1   = new ListNode(0);

            node = head;

            while (half > 0) {
                ListNode next = node.next;
                node.next = l1.next;
                l1.next   = node;
                node      = next;
                --half;
            }

            l1 = l1.next;
            ListNode l2 = len % 2 != 0 ? node.next : node;

            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            return true;
        }
    }

}
