package redo.p1100_1199;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import model.ListNode;
import redo.testUtil.LinkedListTestUtil;

/**  
 * @ClassName: P1171  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1171 {



    static//

    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            Set<Integer> prefixSet = new HashSet<>();
            FixedIntArrayStack stack = new FixedIntArrayStack(1001);

            prefixSet.add(0);
            stack.push(0);

            while (head != null) {
                stack.push(stack.peek() + head.val);
                if (prefixSet.contains(stack.peek())) {
                    int num = stack.pop();
                    while (stack.peek() != num) {
                        prefixSet.remove(stack.pop());
                    }
                } else {
                    prefixSet.add(stack.peek());
                }
                head = head.next;
            }

            head = new ListNode(0);
            ListNode node = head;
            for (int i = 1; i < stack.index; ++i) {
                node.next = new ListNode(stack.stack[i] - stack.stack[i - 1]);
                node = node.next;
            }
            return head.next;
        }

        static class FixedIntArrayStack {
            int index = 0, stack[];

            public FixedIntArrayStack(int len) {
                super();
                this.stack = new int[len];
            }

            public void push(int num) {
                stack[index++] = num;
            }

            public int pop() {
                return stack[--index];
            }

            public int peek() {
                return stack[index - 1];
            }

            public boolean isEmpty() {
                return index == 0;
            }

            public int size() {
                return index;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[3,1]",
            LinkedListTestUtil.toStr(s.removeZeroSumSublists(LinkedListTestUtil.build("[1,2,-3,3,1]"))));

        Assert.assertEquals("[1,2,4]",
            LinkedListTestUtil.toStr(s.removeZeroSumSublists(LinkedListTestUtil.build("[1,2,3,-3,4]"))));

        Assert.assertEquals("[1]",
            LinkedListTestUtil.toStr(s.removeZeroSumSublists(LinkedListTestUtil.build("[1,2,3,-3,-2]"))));

    }

}
