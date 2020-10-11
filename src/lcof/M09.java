package lcof;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: M09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M09 {

    class CQueue {

        private Deque<Integer> stackIn = new LinkedList<>();
        private Deque<Integer> stackOut = new LinkedList<>();

        public CQueue() {}

        public void appendTail(int value) {
            stackIn.addFirst(value);
        }

        public int deleteHead() {
            if (stackOut.isEmpty()) {
                while (!stackIn.isEmpty()) {
                    stackOut.addFirst(stackIn.removeFirst());
                }
            }
            if (stackOut.isEmpty()) {
                return -1;
            }
            return stackOut.removeFirst();
        }
    }

}
