package redo2012_05_29start;

import model.ListNode;

/**  
 * @ClassName: P0206  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年5月29日  
 *  
 */
public class P0206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            while (null != head) {
                ListNode next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = next;
            }
            return dummy.next;
        }
    }
}
