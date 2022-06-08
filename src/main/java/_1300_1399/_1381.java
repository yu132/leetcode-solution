package _1300_1399;

/**  
 * @ClassName: _1381  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _1381 {

    class CustomStack {

        class Node {
            int val;
            int acc;

            public Node(int val, int acc) {
                super();
                this.val = val;
                this.acc = acc;
            }
        }

        private Node[] stack;

        private int index = 0;

        public CustomStack(int maxSize) {
            stack = new Node[maxSize];
        }

        public void push(int x) {
            if (index == stack.length) {
                return;
            }
            stack[index++] = new Node(x, 0);
        }

        public int pop() {
            if (index == 0) {
                return -1;
            }
            Node n = stack[--index];
            if (index != 0) {
                stack[index - 1].acc += n.acc;
            }
            return n.val + n.acc;
        }

        public void increment(int k, int val) {
            if (index == 0) {
                return;
            }
            stack[Math.min(k - 1, index - 1)].acc += val;
        }
    }

}
