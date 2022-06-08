package redo.offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P24  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P24 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode fakeHead = new ListNode(-1), next;
            while (head != null) {
                next = head.next;
                head.next = fakeHead.next;
                fakeHead.next = head;
                head = next;
            }
            return fakeHead.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[5,4,3,2,1]",
            s.reverseList(LinkedListTestUtil.build(1, 2, 3, 4, 5)).toString());
    }

}
