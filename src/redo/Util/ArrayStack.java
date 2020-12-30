package redo.Util;

/**  
 * @ClassName: ArrayStack  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class ArrayStack {

    public static class FixedArrayStack {
        int[] stack;
        int index;

        FixedArrayStack(int maxLen) {
            super();
            this.stack = new int[maxLen];
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
    }

}
