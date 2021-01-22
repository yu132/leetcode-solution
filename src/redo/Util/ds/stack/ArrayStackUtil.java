package redo.Util.ds.stack;

/**  
 * @ClassName: ArrayStack  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class ArrayStackUtil {

    static class FixedArrayStack<T> {
        int index = 0;
        T[] stack;

        @SuppressWarnings("unchecked")
        public FixedArrayStack(int len) {
            super();
            this.stack = (T[])new Object[len];
        }

        public void push(T val) {
            stack[index++] = val;
        }

        public T pop() {
            return stack[--index];
        }

        public T peek() {
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
