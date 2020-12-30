package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P232  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P232 {

    class MyQueue {

        private Deque<Integer> inSatck = new LinkedList<>();
        private Deque<Integer> outSatck = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {}

        /** Push element x to the back of queue. */
        public void push(int x) {
            inSatck.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            moveElement();
            return outSatck.pop();
        }

        /** Get the front element. */
        public int peek() {
            moveElement();
            return outSatck.peek();
        }

        private void moveElement() {
            if (outSatck.isEmpty()) {
                while (!inSatck.isEmpty()) {
                    outSatck.push(inSatck.pop());
                }
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inSatck.isEmpty() && outSatck.isEmpty();
        }
    }

}
