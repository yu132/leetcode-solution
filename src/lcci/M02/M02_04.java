package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M02_04 {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode smallH = new ListNode(0);
            ListNode sn     = smallH;

            ListNode largeH = new ListNode(0);
            ListNode ln     = largeH;

            while (head != null) {
                if (head.val < x) {
                    sn.next = head;
                    sn      = sn.next;
                } else {
                    ln.next = head;
                    ln      = ln.next;
                }
                head = head.next;
            }

            sn.next = largeH.next;
            ln.next = null;

            return smallH.next;
        }
    }

}
