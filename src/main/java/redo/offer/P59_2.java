package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P59_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月7日  
 *  
 */
public class P59_2 {

    class MaxQueue {

        Deque<Integer> queue = new LinkedList<>(), mqueue = new LinkedList<>();

        public MaxQueue() {}

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return mqueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!mqueue.isEmpty() && mqueue.peekLast() < value) {
                mqueue.pollLast();
            }
            mqueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ret = queue.poll();
            if (mqueue.peekFirst() == ret) {
                mqueue.pollFirst();
            }
            return ret;
        }
    }

}
