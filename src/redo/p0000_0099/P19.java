package redo.p0000_0099;

import model.ListNode;

/**  
 * @ClassName: P19  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P19 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dub = new ListNode(-1);

            dub.next = head;

            ListNode slow = dub, fast = dub;
            while (--n > -1) {
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return dub.next;
        }
    }

}
