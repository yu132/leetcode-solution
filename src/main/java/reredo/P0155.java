package reredo;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P0155  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月3日  
 *  
 */
public class P0155 {

    static//

    class MinStack {

        Deque<Data> stack = new LinkedList<>();

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new Data(x, x));
            } else {
                stack.push(new Data(Math.min(x, stack.peek().min), x));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }

        static class Data {
            int min, val;

            public Data(int min, int val) {
                super();
                this.min = min;
                this.val = val;
            }
        }
    }

}
