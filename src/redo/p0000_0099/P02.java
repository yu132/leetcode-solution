package redo.p0000_0099;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P02 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = new ListNode(-1), node = head;

            int inc = 0;

            while (l1 != null || l2 != null || inc != 0) {
                int val = get(l1) + get(l2) + inc;
                node.next = new ListNode(val % 10);

                node = node.next;
                inc = val / 10;
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
        Assert.assertEquals("[7,0,8]",
            s.addTwoNumbers(LinkedListTestUtil.build(2, 4, 3),
                LinkedListTestUtil.build(5, 6, 4)));
    }

}
