package reredo;

import model.ListNode;

/**  
 * @ClassName: P0160  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0160 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {
                a = (a == null ? headB : a.next);
                b = (b == null ? headA : b.next);
            }
            return a;
        }
    }

}
