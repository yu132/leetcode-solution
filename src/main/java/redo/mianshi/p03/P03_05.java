package redo.mianshi.p03;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P03_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_05 {

    class SortedStack {

        Deque<Integer> stack1 = new LinkedList<>(), stack2 = new LinkedList<>();

        public SortedStack() {}

        public void push(int val) {
            while (!stack1.isEmpty() && stack1.peek() < val) {
                stack2.push(stack1.pop());
            }
            while (!stack2.isEmpty() && stack2.peek() > val) {
                stack1.push(stack2.pop());
            }
            stack1.push(val);
        }

        public void pop() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }

        public int peek() {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            if (!stack1.isEmpty()) {
                return stack1.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
