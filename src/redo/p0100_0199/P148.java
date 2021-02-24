package redo.p0100_0199;

import model.ListNode;

/**  
 * @ClassName: P148  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P148 {

    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            return mergeSort(head);
        }

        ListNode mergeSort(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode half = half(node);
            ListNode left = mergeSort(node), right = mergeSort(half);
            ListNode head = new ListNode(-1), n = head;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    n.next = left;
                    left = left.next;
                } else {
                    n.next = right;
                    right = right.next;
                }
                n = n.next;
            }
            if (left != null) {
                n.next = left;
            } else {
                n.next = right;
            }
            return head.next;
        }

        ListNode half(ListNode node) {
            ListNode slow = node, fast = node.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode ret = slow.next;
            slow.next = null;

            return ret;
        }


    }

}
