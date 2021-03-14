package reredo;

import java.util.PriorityQueue;

import model.ListNode;

/**  
 * @ClassName: P0023  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0023 {

    static//

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            ListNode dummy = new ListNode(-1), node = dummy;

            PriorityQueue<Data> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.n.val, b.n.val));

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null) {
                    pq.offer(new Data(lists[i], i));
                    lists[i] = lists[i].next;
                }
            }

            while (!pq.isEmpty()) {
                Data d = pq.poll();
                node.next = d.n;
                node = node.next;
                if (lists[d.index] != null) {
                    pq.offer(new Data(lists[d.index], d.index));
                    lists[d.index] = lists[d.index].next;
                }
            }

            return dummy.next;
        }

        static class Data {
            ListNode n;
            int index;

            public Data(ListNode n, int index) {
                super();
                this.n = n;
                this.index = index;
            }
        }
    }

}
