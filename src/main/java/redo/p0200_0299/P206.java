package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P206  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = head, next = head.next, nn = head.next.next;
            while (nn != null) {
                next.next = node;
                node = next;
                next = nn;
                nn = nn.next;
            }
            next.next = node;
            head.next = null;
            return next;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals("[6,5,4,3,2,1]",
            LinkedListTestUtil.toStr(s.reverseList(LinkedListTestUtil.build(1, 2, 3, 4, 5, 6))));
    }
}
