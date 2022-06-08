package redo.offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P18  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P18 {

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode fakeHead = new ListNode(-1);
            fakeHead.next = head;
            head = fakeHead;
            while (head.next != null) {
                if (head.next.val == val) {
                    head.next = head.next.next;
                    break;
                }
                head = head.next;
            }
            return fakeHead.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[4,1,9]",
            s.deleteNode(LinkedListTestUtil.build(4, 5, 1, 9), 5).toString());
        Assert.assertEquals("[4,5,9]",
            s.deleteNode(LinkedListTestUtil.build(4, 5, 1, 9), 1).toString());

    }

}
