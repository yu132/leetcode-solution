package lcci.M03;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: M03_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月28日  
 *  
 */
public class M03_04 {

    class MyQueue {

        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {}

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.addFirst(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.addFirst(stack1.removeFirst());
                }
            }
            return stack2.removeFirst();
        }

        /** Get the front element. */
        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.addFirst(stack1.removeFirst());
                }
            }
            return stack2.getFirst();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
