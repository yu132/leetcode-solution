package redo.Util.ds.stack;

/**  
 * @ClassName: IntArrayStackUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class IntArrayStackUtil {

    static class FixedIntArrayStack {
        int index = 0, stack[];

        public FixedIntArrayStack(int len) {
            super();
            this.stack = new int[len];
        }

        public void push(int num) {
            stack[index++] = num;
        }

        public int pop() {
            return stack[--index];
        }

        public int peek() {
            return stack[index - 1];
        }

        public boolean isEmpty() {
            return index == 0;
        }

        public int size() {
            return index;
        }
    }

}
