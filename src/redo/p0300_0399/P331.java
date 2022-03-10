package redo.p0300_0399;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P331  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P331 {

    class Solution {
        public boolean isValidSerialization(String preorder) {

            if (preorder.equals("#")) {
                return true;
            }

            Deque<Integer> stack = new LinkedList<>();

            stack.push(0);

            for (String node : preorder.split(",")) {
                if (node.equals("#")) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    int father = stack.pop();
                    while (father != 0) {
                        if (stack.isEmpty()) {
                            return false;
                        }
                        father = stack.pop();
                    }
                    stack.push(1);
                } else {
                    stack.push(0);
                }
            }

            return stack.size() == 1 && stack.pop() == 1;
        }
    }

}
