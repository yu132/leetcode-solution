package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

/**  
 * @ClassName: P155  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P155 {

    class MinStack {

        Deque<Data> stack = new LinkedList<>();

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int x) {
            stack.push(new Data(x, Math.min(x, getMin())));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            if (stack.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return stack.peek().min;
        }

        private class Data {
            int value;
            int min;

            Data(int value, int min) {
                super();
                this.value = value;
                this.min = min;
            }
        }
    }

    @Test
    public void test() {
        MinStack m = new MinStack();

        m.push(-2);
        m.push(0);
        m.push(-3);
        assertEquals(-3, m.getMin());
        m.pop();
        assertEquals(0, m.top());
        assertEquals(-2, m.getMin());
    }

}
