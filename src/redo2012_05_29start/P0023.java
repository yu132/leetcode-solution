package redo2012_05_29start;

import java.util.PriorityQueue;

import model.ListNode;

/**  
 * @ClassName: P0023  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年6月6日  
 *  
 */
public class P0023 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            ListNode dummy = new ListNode(-1), node = dummy;

            PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

            for (ListNode n : lists) {
                if (null != n) {
                    pq.offer(n);
                }
            }

            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                node.next = minNode;
                node = minNode;
                if (null != minNode.next) {
                    pq.offer(minNode.next);
                }
            }

            return dummy.next;
        }
    }

}
