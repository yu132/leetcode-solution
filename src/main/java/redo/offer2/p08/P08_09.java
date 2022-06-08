package redo.offer2.p08;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P08_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_09 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(n, n, 0, new char[n * 2], ans);
            return ans;
        }

        void backtrack(int left, int right, int index, char[] chs,
            List<String> ans) {

            if (left == 0) {
                while (index != chs.length) {
                    chs[index++] = ')';
                }
                ans.add(String.valueOf(chs));
                return;
            }

            if (right > left) {
                chs[index] = ')';
                backtrack(left, right - 1, index + 1, chs, ans);
            }

            chs[index] = '(';
            backtrack(left - 1, right, index + 1, chs, ans);
        }
    }

}
