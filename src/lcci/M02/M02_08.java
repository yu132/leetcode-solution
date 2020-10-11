package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月27日  
 *  
 */
public class M02_08 {

    public class Solution {
        public ListNode detectCycle(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }

            if (fast == null || fast.next == null) {// 没有环
                return null;
            }

            fast = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return slow;
        }
    }

}
