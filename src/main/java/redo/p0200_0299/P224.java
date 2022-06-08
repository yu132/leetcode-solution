package redo.p0200_0299;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P224  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P224 {

    class Solution {

        char neg = '\0', pos = '\1';

        public int calculate(String s) {

            s = s.replaceAll(" ", "");

            Deque<Integer> nums = new LinkedList<>();
            Deque<Character> ops = new LinkedList<>();

            boolean isNum = true;

            int index = 0;

            while (index < s.length()) {

                char ch = s.charAt(index);

                if (Character.isDigit(ch)) {

                    int start = index++;

                    while (index < s.length()
                        && Character.isDigit(s.charAt(index))) {
                        ++index;
                    }

                    nums.push(Integer.parseInt(s.substring(start, index)));

                    dealNegAndPos(nums, ops);

                    isNum = false;
                } else {
                    switch (ch) {
                        case '+':
                        case '-':

                            if (isNum) {
                                if (ch == '+') {
                                    ops.push(pos);
                                } else {
                                    ops.push(neg);
                                }
                                isNum = true;
                                break;
                            }

                            while (!ops.isEmpty() && ops.peek() != '(') {
                                cal(nums, ops);
                            }
                            ops.push(ch);
                            isNum = true;
                            break;
                        case '(':
                            ops.push(ch);

                            isNum = true;
                            break;
                        case ')':
                            while (ops.peek() != '(') {
                                cal(nums, ops);
                            }
                            ops.pop();
                            dealNegAndPos(nums, ops);
                            isNum = false;
                            break;
                    }
                    ++index;
                }
            }

            while (!ops.isEmpty()) {
                cal(nums, ops);
            }

            return nums.peek();
        }

        void dealNegAndPos(Deque<Integer> nums, Deque<Character> ops) {
            if (!ops.isEmpty() && (ops.peek() == pos || ops.peek() == neg)) {

                int num = nums.pop();

                if (ops.pop() == neg) {
                    num = -num;
                }

                nums.push(num);

            }
        }

        void cal(Deque<Integer> nums, Deque<Character> ops) {
            int num2 = nums.pop(), num1 = nums.pop();
            char op = ops.pop();
            nums.push(cal(op, num1, num2));
            dealNegAndPos(nums, ops);
        }

        int cal(char op, int num1, int num2) {
            if (op == '-') {
                return num1 - num2;
            } else {
                return num1 + num2;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.calculate("1 + (-1)"));
        Assert.assertEquals(-2, s.calculate("-(1+1)"));
    }

}
