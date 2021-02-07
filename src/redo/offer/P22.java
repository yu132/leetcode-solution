package redo.offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P22  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P22 {

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode fast, slow;
            fast = slow = head;
            while (k-- != 0) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[4,5]",
            s.getKthFromEnd(LinkedListTestUtil.build(1, 2, 3, 4, 5), 2)
                .toString());
    }

}
