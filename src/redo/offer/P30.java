package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

/**  
 * @ClassName: P30  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P30 {

    class MinStack {

        // 512

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
            if (mstack.peek().equals(stack.pop())) {
                mstack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return mstack.peek();
        }
    }



    @Test
    public void test() {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        s.pop();
        s.pop();
        s.pop();
    }

}
