package _0200_0299;

import java.util.LinkedList;

/**  
 * @ClassName: _227  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _227 {

    class Solution {
        public int calculate(String s) {
            LinkedList<Character> op    = new LinkedList<>();
            LinkedList<Integer>   nums  = new LinkedList<>();

            int                   index = 0;
            while (index < s.length()) {
                if (s.charAt(index) == ' ') {
                    ++index;
                    continue;
                } else if (index >= s.length()) {
                    break;
                } else if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    int num = 0;
                    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                        num = num * 10 + s.charAt(index++) - '0';
                    }
                    nums.addFirst(num);
                } else {
                    switch (s.charAt(index)) {
                        case '+':
                        case '-':
                            while (!op.isEmpty()) {
                                int       n1   = nums.removeFirst(), n2 = nums.removeFirst();
                                Character oper = op.removeFirst();
                                if (oper == '+') {
                                    nums.addFirst(n2 + n1);
                                } else if (oper == '-') {
                                    nums.addFirst(n2 - n1);
                                } else if (oper == '*') {
                                    nums.addFirst(n2 * n1);
                                } else {
                                    nums.addFirst(n2 / n1);
                                }

                            }
                            break;
                        case '*':
                        case '/':
                            while (!op.isEmpty() && (op.getFirst() == '*' || op.getFirst() == '/')) {
                                int n1 = nums.removeFirst(), n2 = nums.removeFirst();
                                if (op.removeFirst() == '*') {
                                    nums.addFirst(n2 * n1);
                                } else {
                                    nums.addFirst(n2 / n1);
                                }
                            }
                    }
                    op.addFirst(s.charAt(index++));
                }
            }
            while (!op.isEmpty()) {
                int       n1   = nums.removeFirst(), n2 = nums.removeFirst();
                Character oper = op.removeFirst();
                if (oper == '+') {
                    nums.addFirst(n2 + n1);
                } else if (oper == '-') {
                    nums.addFirst(n2 - n1);
                } else if (oper == '*') {
                    nums.addFirst(n2 * n1);
                } else {
                    nums.addFirst(n2 / n1);
                }
            }
            return nums.getFirst();
        }
    }

    public static void main(String[] args) {
        new _227().new Solution().calculate(" 3/2");
    }
}
