package redo.p1000_1099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P1019  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1019 {

    static//

    class Solution {
        public int[] nextLargerNodes(ListNode head) {

            int[] ans = new int[len(head)];

            Deque<Data> stack = new LinkedList<>();
            int index = 0;
            while (head != null) {
                while (!stack.isEmpty() && stack.peek().val < head.val) {
                    ans[stack.pop().index] = head.val;
                }
                stack.push(new Data(head.val, index++));
                head = head.next;
            }

            return ans;
        }

        static int len(ListNode head) {
            int len = 0;
            while (head != null) {
                ++len;
                head = head.next;
            }
            return len;
        }

        class Data {
            int val, index;

            public Data(int val, int index) {
                super();
                this.val = val;
                this.index = index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {5, 5, 0}, s.nextLargerNodes(LinkedListTestUtil.build("[2,1,5]")));
        Assert.assertArrayEquals(new int[] {7, 0, 5, 5, 0}, s.nextLargerNodes(LinkedListTestUtil.build("[2,7,4,3,5]")));
        Assert.assertArrayEquals(new int[] {7, 9, 9, 9, 0, 5, 0, 0},
            s.nextLargerNodes(LinkedListTestUtil.build("[1,7,5,1,9,2,5,1]")));
    }

}
