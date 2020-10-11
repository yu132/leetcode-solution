package lcof;

import model.ListNode;

/**  
 * @ClassName: M24  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M24 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = new ListNode(0);
            while (head != null) {
                ListNode next = head.next;
                head.next    = newHead.next;
                newHead.next = head;
                head         = next;
            }
            return newHead.next;
        }
    }

}
