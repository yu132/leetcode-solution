package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P09 {

    class CQueue {

        Deque<Integer> stack1, stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }

}
