package _0000_0099;

import java.util.LinkedList;

/**  
 * @ClassName: _71  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月11日  
 *  
 */
public class _71 {

    class Solution {
        public String simplifyPath(String path) {
            LinkedList<String> stack = new LinkedList<>();

            int                index = 0;

            char[]             chs   = path.toCharArray();

            while (index < chs.length) {
                if (chs[index] == '/') {
                    ++index;
                    if (stack.isEmpty() || !stack.getFirst().equals("/")) {
                        stack.addFirst("/");
                    }
                } else {
                    int end = index + 1;
                    while (end != chs.length && chs[end] != '/') {
                        ++end;
                    }
                    String str = path.substring(index, end);
                    if (str.equals("..")) {
                        if (stack.size() > 1) {
                            stack.removeFirst();
                            stack.removeFirst();
                        }
                    } else if (!str.equals(".")) {
                        stack.addFirst(str);
                    }
                    index = end;
                }
            }

            if (stack.size() != 1 && stack.getFirst().equals("/")) {
                stack.removeFirst();
            }

            StringBuilder sb = new StringBuilder(path.length());

            while (!stack.isEmpty()) {
                sb.append(stack.removeLast());
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new _71().new Solution().simplifyPath("/a//b////c/d//././/.."));
    }

}
