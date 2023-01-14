package redo.mianshi.p02;

import model.ListNode;

/**  
 * @ClassName: P02_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P02_02 {

    class Solution {
        public int kthToLast(ListNode head, int k) {
            ListNode node = head;
            while (k-- != 0) {
                node = node.next;
            }
            while (node != null) {
                head = head.next;
                node = node.next;
            }
            return head.val;
        }
    }

}
