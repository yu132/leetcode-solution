package reredo;

import model.ListNode;

/**  
 * @ClassName: P0092  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0092 {

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode dummy = new ListNode(-1);

            dummy.next = head;

            ListNode node = dummy;

            for (int i = 1; i < left; ++i) {
                node = node.next;
            }

            ListNode tail = node.next;

            head = node.next;

            for (int i = left; i <= right; ++i) {
                ListNode next = head.next;
                head.next = node.next;
                node.next = head;
                head = next;
            }

            tail.next = head;

            return dummy.next;
        }
    }

}
