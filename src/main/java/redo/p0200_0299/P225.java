package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P225  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P225 {

    class MyStack {

        private Deque<Integer> queue = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {}

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            int n = queue.size();
            while (--n > 0) {
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
