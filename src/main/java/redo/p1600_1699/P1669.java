package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P1669  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1669 {

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode head = new ListNode(0), node = head, part2;
            head.next = list1;

            while (true) {
                if (a > 0) {
                    --a;
                    --b;
                } else {
                    break;
                }
                node = node.next;
            }
            part2 = node.next;
            node.next = list2;

            while (list2.next != null) {
                list2 = list2.next;
            }

            while (true) {
                if (b >= 0) {
                    --b;
                } else {
                    break;
                }
                part2 = part2.next;
            }

            list2.next = part2;

            return head.next;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[0,1,2,1000000,1000001,1000002,5]",
            LinkedListTestUtil.toStr(s.mergeInBetween(LinkedListTestUtil.build("[0,1,2,3,4,5]"), 3, 4,
                LinkedListTestUtil.build("[1000000,1000001,1000002]"))));

        Assert.assertEquals("[0,1,1000000,1000001,1000002,1000003,1000004,6]",
            LinkedListTestUtil.toStr(s.mergeInBetween(LinkedListTestUtil.build("[0,1,2,3,4,5,6]"), 2, 5,
                LinkedListTestUtil.build("[1000000,1000001,1000002,1000003,1000004]"))));

        Assert.assertEquals("[100,101,4,5,6]", LinkedListTestUtil.toStr(s
            .mergeInBetween(LinkedListTestUtil.build("[0,1,2,3,4,5,6]"), 0, 3, LinkedListTestUtil.build("[100,101]"))));
        Assert.assertEquals("[100,101]", LinkedListTestUtil.toStr(s
            .mergeInBetween(LinkedListTestUtil.build("[0,1,2,3,4,5,6]"), 0, 6, LinkedListTestUtil.build("[100,101]"))));

    }

}
