package redo.p0100_0199;

import model.ListNode;

/**  
 * @ClassName: P160  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P160 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode a = headA, b = headB;
            while (a != b) {
                a = (a == null ? headB : a.next);
                b = (b == null ? headA : b.next);
            }
            return a;
        }
    }

}
