package redo.offer2.p02;

import model.ListNode;

/**  
 * @ClassName: P02_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P02_04 {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode headLow = new ListNode(-1), nodeLow = headLow,
                headHigh = new ListNode(-1), nodeHigh = headHigh;

            while (head != null) {
                if (head.val < x) {
                    nodeLow.next = head;
                    nodeLow = nodeLow.next;
                } else {
                    nodeHigh.next = head;
                    nodeHigh = nodeHigh.next;
                }
                head = head.next;
            }

            nodeLow.next = headHigh.next;
            nodeHigh.next = null;

            return headLow.next;
        }
    }

}
