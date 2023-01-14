package redo.mianshi.p03;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P03_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_02 {

    class MinStack {

        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> mstack = new LinkedList<>();

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int x) {
            stack.push(x);
            if (mstack.isEmpty() || mstack.peek() >= x) {
                mstack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            if (mstack.peek().intValue() == stack.pop()) {
                mstack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty()) {
                throw new RuntimeException();
            }
            return mstack.peek();
        }
    }

}
