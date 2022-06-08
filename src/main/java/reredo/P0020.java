package reredo;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P20  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月4日  
 *  
 */
public class P0020 {

    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new LinkedList<>();

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (ch == ')') {
                        if (stack.peek() != '(') {
                            return false;
                        }
                    } else if (ch == ']') {
                        if (stack.peek() != '[') {
                            return false;
                        }
                    } else if (ch == '}') {
                        if (stack.peek() != '{') {
                            return false;
                        }
                    }
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }

}
