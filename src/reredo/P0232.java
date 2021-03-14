package reredo;

import java.util.LinkedList;

/**  
 * @ClassName: P0232  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月5日  
 *  
 */
public class P0232 {

    class MyQueue {

        LinkedList<Integer> stack1 = new LinkedList<>(),
            stack2 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {}

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            moveIfEmpty();
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            moveIfEmpty();
            return stack2.peek();
        }

        void moveIfEmpty() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
