package lcci.M03;

/**  
 * @ClassName: M03_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月27日  
 *  
 */
public class M03_01 {

    class TripleInOne {

        private int[] stackIndex = new int[3];
        private int[] stack;
        private int size;

        public TripleInOne(int stackSize) {
            stack = new int[3 * stackSize];
            size  = stackSize;
        }

        public void push(int stackNum, int value) {
            if (stackIndex[stackNum] == size) {
                return;
            }
            stack[stackNum * size + stackIndex[stackNum]++] = value;
        }

        public int pop(int stackNum) {
            if (stackIndex[stackNum] == 0) {
                return -1;
            }
            return stack[stackNum * size + --stackIndex[stackNum]];
        }

        public int peek(int stackNum) {
            if (stackIndex[stackNum] == 0) {
                return -1;
            }
            return stack[stackNum * size + stackIndex[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return stackIndex[stackNum] == 0;
        }
    }

}
