package _1600_1699;

/**  
 * @ClassName: _1614  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年10月17日  
 *  
 */
public class _1614 {

    class Solution {
        public int maxDepth(String s) {

            int depth = 0;
            int max   = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    ++depth;
                    max = Math.max(max, depth);
                } else if (ch == ')') {
                    --depth;
                }
            }

            return max;
        }
    }

}
