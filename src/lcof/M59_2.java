package lcof;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: M59_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class M59_2 {

    class MaxQueue {

        private Deque<Node> mq = new LinkedList<>();

        private Deque<Integer> q = new LinkedList<>();

        private int rI = 0, index = 0;

        public MaxQueue() {}

        public int max_value() {
            if (q.isEmpty()) {
                return -1;
            }
            return mq.getFirst().num;
        }

        public void push_back(int value) {
            q.addLast(value);
            while (!mq.isEmpty() && mq.getLast().num <= value) {
                mq.removeLast();
            }
            mq.addLast(new Node(value, index++));
        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            if (mq.getFirst().index == rI++) {
                mq.removeFirst();
            }
            return q.removeFirst();
        }

        class Node {
            int num;
            int index;

            public Node(int num, int index) {
                super();
                this.num   = num;
                this.index = index;
            }
        }

    }

}
