package redo.p0000_0099;

import java.util.PriorityQueue;

import model.ListNode;

/**  
 * @ClassName: P23  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P23 {

    static//

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Data> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.node.val, b.node.val));

            int finish = 0;

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    ++finish;
                } else {
                    pq.offer(new Data(i, lists[i]));
                    lists[i] = lists[i].next;
                }
            }

            ListNode head = new ListNode(-1), node = head;

            while (finish < lists.length) {
                Data d = pq.poll();
                node.next = d.node;
                node = node.next;
                if (lists[d.index] == null) {
                    ++finish;
                } else {
                    pq.offer(new Data(d.index, lists[d.index]));
                    lists[d.index] = lists[d.index].next;
                }
            }

            return head.next;
        }

        static class Data {
            int index;
            ListNode node;

            Data(int index, ListNode node) {
                super();
                this.index = index;
                this.node = node;
            }
        }
    }

}
