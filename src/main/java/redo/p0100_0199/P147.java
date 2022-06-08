package redo.p0100_0199;

import model.ListNode;

/**  
 * @ClassName: P147  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月26日  
 *  
 */
public class P147 {

    class Solution {
        public ListNode insertionSortList(ListNode head) {

            ListNode fake = new ListNode(Integer.MIN_VALUE);

            while (head != null) {
                ListNode nodePrev = findPrev(fake, head);
                ListNode next = head.next;
                appendNext(nodePrev, head);
                head = next;
            }

            return fake.next;
        }

        ListNode findPrev(ListNode fake, ListNode node) {
            while (fake.next != null) {
                if (fake.val <= node.val && fake.next.val > node.val) {
                    return fake;
                }
                fake = fake.next;
            }
            return fake;
        }

        void appendNext(ListNode node, ListNode toAppend) {
            toAppend.next = node.next;
            node.next = toAppend;
        }
    }

}
