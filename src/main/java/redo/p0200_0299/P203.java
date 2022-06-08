package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;
import static redo.testUtil.LinkedListTestUtil.*;

import org.junit.Test;

import model.ListNode;

/**  
 * @ClassName: P203  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P203 {

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode tempHead = new ListNode(0), node = tempHead;
            tempHead.next = head;
            while (node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return tempHead.next;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("[1,2,3,4,5]", toStr(s.removeElements(build(1, 2, 3, 4, 5, 6), 6)));
        assertEquals("[2,3,4,5,6]", toStr(s.removeElements(build(1, 2, 3, 4, 5, 6), 1)));
    }

}
