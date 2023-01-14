package old._0000_0099;

import model.ListNode;

/**  
 * @ClassName: _82  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月11日  
 *  
 */
public class _82 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            return helper(head, false);
        }

        public ListNode helper(ListNode node, boolean same) {
            if (node.next == null) {
                return same ? null : node;
            }
            if (same || node.val == node.next.val) {
                return helper(node.next, node.val == node.next.val);
            } else {
                node.next = helper(node.next, node.val == node.next.val);
                return node;
            }
        }
    }

}
