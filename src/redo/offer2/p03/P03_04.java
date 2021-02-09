package redo.offer2.p03;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P03_04  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_04 {

    class MyQueue {

        Deque<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyQueue() {}

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            arrangeIfNeed();
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            arrangeIfNeed();
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.peek();
        }

        void arrangeIfNeed() {
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
