package reredo;

import model.ListNode;

/**  
 * @ClassName: P206  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月2日  
 *  
 */
public class P0206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = next;
            }
            return dummy.next;
        }
    }

}
