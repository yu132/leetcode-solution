package redo.offer;

import model.ListNode;

/**  
 * @ClassName: P52  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P52 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode ha = headA, hb = headB;

            while (ha != hb) {
                ha = ha == null ? headB : ha.next;
                hb = hb == null ? headA : hb.next;
            }

            return ha;
        }
    }

}
