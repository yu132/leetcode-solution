package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_07  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月27日  
 *  
 */
public class M02_07 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }

            return a;
        }
    }

}
