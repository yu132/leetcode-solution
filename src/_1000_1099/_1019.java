package _1000_1099;

import model.ListNode;

/**  
 * @ClassName: _1019  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月8日  
 *  
 */
public class _1019 {

    class Solution {
        public int[] nextLargerNodes(ListNode head) {

            ListNode temp  = head;

            int      index = 0, len = 0;

            while (temp != null) {
                ++len;
                temp = temp.next;
            }

            Node  first = new Node(0, 0, null);

            int[] ans   = new int[len];

            while (head != null) {
                while (first.next != null && first.next.val < head.val) {
                    ans[first.next.index] = head.val;
                    first.next            = first.next.next;
                }

                first.next = new Node(head.val, index, first.next);

                ++index;
                head = head.next;
            }

            while (first.next != null) {
                ans[first.next.index] = 0;
                first.next            = first.next.next;
            }

            return ans;
        }

        class Node {
            int val;
            int index;

            Node next;

            public Node(int val, int index, Node next) {
                super();
                this.val   = val;
                this.index = index;
                this.next  = next;
            }
        }
    }

}
