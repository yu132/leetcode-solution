package redo.p0100_0199;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P150  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P150 {

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<>();

            for (String str : tokens) {
                if (isOperator(str)) {
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(cul(num1, num2, str.charAt(0)));
                } else {
                    stack.push(Integer.valueOf(str));
                }
            }

            return stack.pop();
        }

        boolean isOperator(String str) {
            return str.length() == 1 && !Character.isDigit(str.charAt(0));
        }

        int cul(int num1, int num2, char op) {
            switch (op) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                case '/':
                    return num1 / num2;
            }
            throw new RuntimeException();
        }
    }

}
