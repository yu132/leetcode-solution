package redo.offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P25  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P25 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1), node = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    l2 = l2.next;
                }
                node = node.next;
            }
            if (l1 != null) {
                node.next = l1;
            } else {
                node.next = l2;
            }
            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[1,1,2,3,4,4]",
            s.mergeTwoLists(LinkedListTestUtil.build(1, 2, 4),
                LinkedListTestUtil.build(1, 3, 4)).toString());
    }
}
