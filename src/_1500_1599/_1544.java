package _1500_1599;

import java.util.LinkedList;

/**  
 * @ClassName: _1544  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年8月26日  
 *  
 */
public class _1544 {

    class Solution {
        public String makeGood(String s) {

            LinkedList<Character> stack = new LinkedList<>();

            final int             diff  = 'a' - 'A';

            for (int i = 0; i < s.length(); ++i) {
                if (stack.isEmpty()) {
                    stack.addLast(s.charAt(i));
                } else {
                    if (Math.abs(stack.getLast() - s.charAt(i)) == diff) {
                        stack.removeLast();
                    } else {
                        stack.addLast(s.charAt(i));
                    }
                }
            }

            StringBuilder sb = new StringBuilder(stack.size());

            for (char each : stack) {
                sb.append(each);
            }

            return sb.toString();
        }
    }

}
