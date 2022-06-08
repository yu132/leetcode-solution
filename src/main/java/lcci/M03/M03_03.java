package lcci.M03;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @ClassName: M03_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月28日  
 *  
 */
public class M03_03 {

    class StackOfPlates {

        private ArrayList<int[]> stacks = new ArrayList<>();
        private ArrayList<AtomicInteger> index = new ArrayList<>();

        private int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
        }

        public void push(int val) {
            if (cap == 0) {
                return;
            }
            if (stacks.size() == 0 || index.get(index.size() - 1).get() == cap) {
                stacks.add(new int[cap]);
                index.add(new AtomicInteger(0));
            }
            stacks.get(stacks.size() - 1)[index.get(index.size() - 1).getAndIncrement()] = val;
        }

        public int pop() {
            if (stacks.size() == 0) {
                return -1;
            }
            int val = stacks.get(stacks.size() - 1)[index.get(index.size() - 1).decrementAndGet()];
            if (index.get(index.size() - 1).get() == 0) {
                stacks.remove(stacks.size() - 1);
                index.remove(index.size() - 1);
            }
            return val;
        }

        public int popAt(int index) {
            if (index >= stacks.size()) {
                return -1;
            }
            int val = stacks.get(index)[this.index.get(index).decrementAndGet()];
            if (this.index.get(index).get() == 0) {
                stacks.remove(index);
                this.index.remove(index);
            }
            return val;
        }
    }

}
