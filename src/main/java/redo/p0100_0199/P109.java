package redo.p0100_0199;

import model.ListNode;
import model.TreeNode;

/**  
 * @ClassName: P109  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P109 {

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                TreeNode node = new TreeNode(head.val);
                return node;
            }
            ListNode half = half(head);
            TreeNode node = new TreeNode(half.val);
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(half.next);
            return node;
        }

        ListNode half(ListNode head) {
            ListNode fast = head.next, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode ret = slow.next;
            slow.next = null;
            return ret;
        }
    }

}
