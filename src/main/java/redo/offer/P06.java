package redo.offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P06 {

    class Solution {

        int len;

        public int[] reversePrint(ListNode head) {
            len = 0;
            head = reverse(head);
            int[] arr = new int[len];
            int index = 0;
            while (head != null) {
                arr[index++] = head.val;
                head = head.next;
            }
            return arr;
        }

        public ListNode reverse(ListNode node) {
            ListNode head = new ListNode(-1);
            while (node != null) {
                ListNode next = node.next;
                node.next = head.next;
                head.next = node;
                node = next;
                ++len;
            }
            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 3, 1},
            s.reversePrint(LinkedListTestUtil.build(1, 3, 2)));
    }
}
