package redo.p0000_0099;

import model.ListNode;

/**  
 * @ClassName: P96  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P86 {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(-1), s = small,
                big = new ListNode(-1), b = big;

            for (; head != null; head = head.next) {
                if (head.val < x) {
                    s.next = head;
                    s = s.next;
                } else {
                    b.next = head;
                    b = b.next;
                }
            }

            s.next = big.next;
            b.next = null;

            return small.next;
        }
    }

}
