package redo.mianshi.p02;

import model.ListNode;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P02_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P02_05 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1), node = head;

            int inc = 0;
            while (l1 != null || l2 != null || inc != 0) {
                int val = get(l1) + get(l2) + inc;
                node.next = new ListNode(val % 10);
                inc = val / 10;

                node = node.next;
                l1 = next(l1);
                l2 = next(l2);
            }

            return head.next;
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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(s.addTwoNumbers(LinkedListTestUtil.build(7, 1, 6),
            LinkedListTestUtil.build(6, 9, 3, 1)));
    }

}
