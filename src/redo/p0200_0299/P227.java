package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P227  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P227 {

    class Solution {
        public int calculate(String s) {

            Deque<Integer> nums = new LinkedList<>();

            Deque<Character> ops = new LinkedList<>();

            for (int i = 0; i < s.length(); ++i) {

                if (isNum(s, i)) {
                    int num = s.charAt(i) - '0';
                    while (i + 1 < s.length()
                        && Character.isDigit(s.charAt(i + 1))) {
                        ++i;
                        num = num * 10 + s.charAt(i) - '0';
                    }
                    nums.push(num);
                } else if (isOp(s, i)) {
                    char op = s.charAt(i);

                    switch (op) {
                        case '+':
                        case '-':
                            while (!ops.isEmpty()) {
                                culTop(nums, ops);
                            }
                            break;
                        case '*':
                        case '/':
                            while (!ops.isEmpty()
                                && (ops.peek() == '*' || ops.peek() == '/')) {
                                culTop(nums, ops);
                            }
                            break;
                    }

                    ops.push(op);
                }
            }

            while (!ops.isEmpty()) {
                culTop(nums, ops);
            }

            return nums.pop();
        }

        void culTop(Deque<Integer> nums, Deque<Character> ops) {
            char topOp = ops.pop();
            int num2 = nums.pop(), num1 = nums.pop();
            nums.push(cul(num1, num2, topOp));
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

        boolean isNum(String s, int index) {
            return Character.isDigit(s.charAt(index));
        }

        boolean isOp(String s, int index) {
            return s.charAt(index) != ' ';
        }
    }

}
