package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P234  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P234 {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }
            int num = 0;
            ListNode node = head;
            while (node != null) {
                ++num;
                node = node.next;
            }
            int half = (num + 1) / 2;

            if (num == 1) {
                return true;
            }

            node = null;
            ListNode next = head;
            while (half-- != 0) {
                ListNode nn = next.next;
                next.next = node;
                node = next;
                next = nn;
            }

            ListNode left, right = next;

            if (num % 2 == 1) {
                left = node.next;
            } else {
                left = node;
            }

            while (left != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }

            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(false, s.isPalindrome(LinkedListTestUtil.build(1, 2)));
        assertEquals(true, s.isPalindrome(LinkedListTestUtil.build(1, 2, 1)));
        assertEquals(true, s.isPalindrome(LinkedListTestUtil.build(1, 2, 2, 1)));
        assertEquals(true, s.isPalindrome(LinkedListTestUtil.build(1)));
        assertEquals(true, s.isPalindrome(LinkedListTestUtil.build()));
    }
}
