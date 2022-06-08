package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P1290  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1290 {

    class Solution {
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while (head != null) {
                num = num << 1 | head.val;
                head = head.next;
            }
            return num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.getDecimalValue(LinkedListTestUtil.build(1, 0, 1)));
        Assert.assertEquals(0, s.getDecimalValue(LinkedListTestUtil.build(0)));
        Assert.assertEquals(1, s.getDecimalValue(LinkedListTestUtil.build(1)));
        Assert.assertEquals(18880,
            s.getDecimalValue(LinkedListTestUtil.build(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0)));
        Assert.assertEquals(0, s.getDecimalValue(LinkedListTestUtil.build(0, 0)));
    }

}
