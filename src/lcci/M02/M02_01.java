package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M02_01 {

    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {

            boolean[] flag = new boolean[20001];

            ListNode  node = new ListNode(0);

            node.next = head;

            head      = node;

            while (node != null && node.next != null) {
                if (flag[node.next.val]) {
                    node.next = node.next.next;
                } else {
                    flag[node.next.val] = true;
                    node                = node.next;
                }
            }

            return head.next;
        }
    }

}
