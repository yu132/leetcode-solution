package redo.p0000_0099;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P82  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P82 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = new ListNode(0);
            node.next = head;
            head = node;

            while (node != null) {
                while (node.next != null && node.next.next != null && node.next.val == node.next.next.val) {
                    int val = node.next.val;
                    while (node.next != null && node.next.val == val) {
                        node.next = node.next.next;
                    }
                }
                node = node.next;
            }

            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,2,5]", s.deleteDuplicates(LinkedListTestUtil.build(1, 2, 3, 3, 4, 4, 5)).toString());
        Assert.assertEquals("[2,3]", s.deleteDuplicates(LinkedListTestUtil.build(1, 1, 1, 2, 3)).toString());
        Assert.assertEquals(null, s.deleteDuplicates(LinkedListTestUtil.build(1, 1)));
    }

}
