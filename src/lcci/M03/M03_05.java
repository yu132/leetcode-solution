package lcci.M03;

import java.util.PriorityQueue;

/**  
 * @ClassName: M03_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月28日  
 *  
 */
public class M03_05 {

    class SortedStack {

        private PriorityQueue<Integer> pq = new PriorityQueue<>();

        public SortedStack() {}

        public void push(int val) {
            pq.offer(val);
        }

        public void pop() {
            pq.poll();
        }

        public int peek() {
            return pq.peek() == null ? -1 : pq.peek();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }
    }

}
