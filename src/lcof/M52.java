package lcof;

import model.ListNode;

/**  
 * @ClassName: M52  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月22日  
 *  
 */
public class M52 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            if (headA == null || headB == null) {
                return null;
            }

            ListNode p1 = headA, p2 = headB;

            while (p1 != p2) {
                p1 = (p1 == null ? headB : p1.next);
                p2 = (p2 == null ? headA : p2.next);
            }

            return p1;
        }
    }

}
