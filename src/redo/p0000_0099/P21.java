package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;
import static redo.testUtil.LinkedListTestUtil.*;

import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P21  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P21 {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0), node = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    node = node.next;
                    l2 = l2.next;
                }
            }
            while (l1 != null) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
            return head.next;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[1,1,2,3,4,4]", LinkedListTestUtil.toStr(s.mergeTwoLists(build(1, 2, 4), build(1, 3, 4))));
    }
}
