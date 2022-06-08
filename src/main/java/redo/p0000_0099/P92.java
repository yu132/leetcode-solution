package redo.p0000_0099;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: p91  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P92 {

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {

            ListNode fake = new ListNode(-1), node = fake;

            fake.next = head;

            int count = 1;

            while (count < left) {
                node = node.next;
                ++count;
            }

            ListNode rev = node.next, revHead = new ListNode(-1), last = rev;

            while (count <= right) {
                ListNode next = rev.next;
                rev.next = revHead.next;
                revHead.next = rev;
                rev = next;
                ++count;
            }

            ListNode p1H = fake.next, p1T = node, p2H = revHead.next,
                p2T = last, p3H = rev;

            p1T.next = p2H;
            p2T.next = p3H;

            if (left == 1) {
                return p2H;
            }

            return p1H;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[3,2,1,4,5]",
            s.reverseBetween(LinkedListTestUtil.build(1, 2, 3, 4, 5), 1, 3));
    }
}
