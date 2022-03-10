package redo.p0300_0399;

import java.util.concurrent.ThreadLocalRandom;

import model.ListNode;

/**  
 * @ClassName: P382  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P382 {

    class Solution {

        int len;
        ListNode head;

        ThreadLocalRandom r = ThreadLocalRandom.current();

        /** @param head The linked list's head.
            Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            len = len(head);
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode node = head;
            int n = len;
            while (!choose(n--)) {
                node = node.next;
            }
            return node.val;
        }

        boolean choose(int n) {
            return r.nextInt(n) == 0;
        }

        int len(ListNode head) {
            int len = 0;
            while (head != null) {
                ++len;
                head = head.next;
            }
            return len;
        }
    }

}
