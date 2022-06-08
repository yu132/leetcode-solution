package redo.p0300_0399;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P390  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P390 {

    class Solution {
        public int lastRemaining(int n) {
            Deque<Integer> stack = new LinkedList<>();

            boolean left2Right = true;

            for (; n != 1; n /= 2, left2Right = !left2Right) {
                if (left2Right || (n & 1) == 1) {
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            }

            while (!stack.isEmpty()) {
                if (stack.pop() == 1) {
                    n = n * 2;
                } else {
                    n = n * 2 - 1;
                }
            }
            return n;
        }
    }


}
