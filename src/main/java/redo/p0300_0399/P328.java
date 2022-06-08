package redo.p0300_0399;

import model.ListNode;

/**  
 * @ClassName: P328  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P328 {

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode oddHead = new ListNode(-1), odd = oddHead,
                evenHead = new ListNode(-1), even = evenHead;
            boolean isOdd = true;
            for (; head != null; head = head.next, isOdd = !isOdd) {
                if (isOdd) {
                    odd.next = head;
                    odd = odd.next;
                } else {
                    even.next = head;
                    even = even.next;
                }
            }
            odd.next = evenHead.next;
            even.next = null;
            return oddHead.next;
        }
    }

}
