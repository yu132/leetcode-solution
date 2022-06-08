package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P22  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P22 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(0, n, 0, new char[2 * n], ans);
            return ans;
        }

        void backtrack(int left, int n, int index, char[] chs,
            List<String> ans) {
            if (n == 0) {
                while (left-- != 0) {
                    chs[index++] = ')';
                }
                ans.add(String.valueOf(chs));
                return;
            }
            chs[index] = '(';
            backtrack(left + 1, n - 1, index + 1, chs, ans);

            if (left != 0) {
                chs[index] = ')';
                backtrack(left - 1, n, index + 1, chs, ans);
            }
        }
    }

}
