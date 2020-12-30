package redo.Util.stack;

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
public class CharArrayStackUtil {

    static class FixedCharArrayStack {
        int index = 0;
        char[] stack;

        public FixedCharArrayStack(int len) {
            super();
            this.stack = new char[len];
        }

        public void push(char num) {
            stack[index++] = num;
        }

        public char pop() {
            return stack[--index];
        }

        public char peek() {
            return stack[index - 1];
        }

        public boolean isEmpty() {
            return index == 0;
        }
    }

}
