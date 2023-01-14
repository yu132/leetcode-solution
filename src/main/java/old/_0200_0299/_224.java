package old._0200_0299;

import java.util.ArrayList;

/**  
 * @ClassName: _224  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _224 {

    class Solution {
        public int calculate(String s) {

            ArrayList<Character> op    = new ArrayList<>();
            ArrayList<Integer>   num   = new ArrayList<>();

            int                  index = 0;

            while (true) {
                while (index != s.length() && s.charAt(index) == ' ') {
                    ++index;
                }
                if (index == s.length()) {
                    break;
                }
                if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                    int n = 0;
                    while (index != s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                        n = n * 10 + s.charAt(index++) - '0';
                    }
                    num.add(n);
                    continue;
                }
                char opn = s.charAt(index++);
                switch (opn) {
                    case '+':
                    case '-':
                        while (!op.isEmpty() && (op.get(op.size() - 1) == '-' || op.get(op.size() - 1) == '+')) {
                            char c = op.remove(op.size() - 1);
                            if (c == '+') {
                                int n1 = num.remove(num.size() - 1);
                                int n2 = num.remove(num.size() - 1);
                                num.add(n2 + n1);
                            } else {
                                int n1 = num.remove(num.size() - 1);
                                int n2 = num.remove(num.size() - 1);
                                num.add(n2 - n1);
                            }
                        }
                    case '(':
                        op.add(opn);
                        continue;
                    case ')':
                        while (op.get(op.size() - 1) != '(') {
                            char c = op.remove(op.size() - 1);
                            if (c == '+') {
                                int n1 = num.remove(num.size() - 1);
                                int n2 = num.remove(num.size() - 1);
                                num.add(n2 + n1);
                            } else {
                                int n1 = num.remove(num.size() - 1);
                                int n2 = num.remove(num.size() - 1);
                                num.add(n2 - n1);
                            }
                        }
                        op.remove(op.size() - 1);
                        continue;
                }
            }

            while (!op.isEmpty()) {
                char c = op.remove(op.size() - 1);
                if (c == '+') {
                    int n1 = num.remove(num.size() - 1);
                    int n2 = num.remove(num.size() - 1);
                    num.add(n2 + n1);
                } else {
                    int n1 = num.remove(num.size() - 1);
                    int n2 = num.remove(num.size() - 1);
                    num.add(n2 - n1);
                }
            }

            return num.get(0);
        }
    }


    public static void main(String[] args) {
        System.out.println(new _224().new Solution().calculate("1 - (1+1)"));
    }
}
