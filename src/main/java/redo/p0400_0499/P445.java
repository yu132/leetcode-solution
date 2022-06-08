package redo.p0400_0499;

import model.ListNode;

/**  
 * @ClassName: P445  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P445 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);

            return add(l1, l2);
        }

        ListNode add(ListNode node1, ListNode node2) {
            ListNode dummy = new ListNode(-1);

            int inc = 0;

            while (node1 != null || node2 != null || inc != 0) {
                int val = get(node1) + get(node2) + inc;
                inc = val / 10;
                ListNode node = new ListNode(val % 10);
                node.next = dummy.next;
                dummy.next = node;

                node1 = next(node1);
                node2 = next(node2);
            }

            return dummy.next;
        }

        int get(ListNode node) {
            if (node == null) {
                return 0;
            }
            return node.val;
        }

        ListNode next(ListNode node) {
            if (node == null) {
                return null;
            }
            return node.next;
        }

        ListNode reverse(ListNode node) {
            ListNode dummy = new ListNode(-1);
            while (node != null) {
                ListNode next = node.next;
                node.next = dummy.next;
                dummy.next = node;
                node = next;
            }
            return dummy.next;
        }

    }

}
