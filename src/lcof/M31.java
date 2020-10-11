package lcof;

/**  
 * @ClassName: M31  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月18日  
 *  
 */
public class M31 {

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int[] stack        = new int[pushed.length];
            int   indexOfStack = 0, indexPushed = 0, indexPopped = 0;
            while (true) {
                if (indexPopped == popped.length) {
                    return true;
                }
                if (indexOfStack == 0) {
                    if (indexPushed == pushed.length) {
                        return false;
                    }
                    stack[indexOfStack++] = pushed[indexPushed++];
                }
                if (stack[indexOfStack - 1] == popped[indexPopped]) {
                    --indexOfStack;
                    ++indexPopped;
                } else {
                    if (indexPushed == pushed.length) {
                        return false;
                    }
                    stack[indexOfStack++] = pushed[indexPushed++];
                }
            }
        }
    }

}
