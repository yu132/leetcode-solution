package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;
import static redo.testUtil.LinkedListTestUtil.*;

import org.junit.Test;

import model.ListNode;

/**  
 * @ClassName: P83  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P83 {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode node = head;
            while (node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[]", toStr(s.deleteDuplicates(build())));
        assertEquals("[1]", toStr(s.deleteDuplicates(build(1))));
        assertEquals("[1,2]", toStr(s.deleteDuplicates(build(1, 1, 2))));
        assertEquals("[1,2,3]", toStr(s.deleteDuplicates(build(1, 1, 2, 3, 3))));
    }
}
