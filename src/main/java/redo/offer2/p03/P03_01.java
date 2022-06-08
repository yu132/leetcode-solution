package redo.offer2.p03;

/**  
 * @ClassName: P03_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P03_01 {

    class TripleInOne {

        int[] indexes, arr;
        int stackSize;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            indexes = new int[] {0, stackSize, 2 * stackSize};
            arr = new int[3 * stackSize];
        }

        public void push(int stackNum, int value) {
            if (!isFull(stackNum)) {
                arr[indexes[stackNum]++] = value;
            }
        }

        public int pop(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }
            return arr[--indexes[stackNum]];
        }

        public int peek(int stackNum) {
            if (isEmpty(stackNum)) {
                return -1;
            }
            return arr[indexes[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return indexes[stackNum] == stackNum * stackSize;
        }

        boolean isFull(int stackNum) {
            return indexes[stackNum] == (stackNum + 1) * stackSize - 1;
        }
    }

}
