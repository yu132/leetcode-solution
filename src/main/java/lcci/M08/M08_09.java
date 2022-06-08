package lcci.M08;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: M08_09  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月5日  
 *  
 */
public class M08_09 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            helper(0, 2 * n, 0, 0, new char[2 * n], ans);
            return ans;
        }

        public void helper(int index, int max, int left, int right, char[] chs, List<String> ans) {

            if (index == max) {
                ans.add(String.valueOf(chs));
                return;
            }

            if (right == left) {
                chs[index] = '(';
                helper(index + 1, max, left + 1, right, chs, ans);
                return;
            } else if (left == max / 2) {
                chs[index] = ')';
                helper(index + 1, max, left, right + 1, chs, ans);
                return;
            }

            chs[index] = '(';
            helper(index + 1, max, left + 1, right, chs, ans);
            chs[index] = ')';
            helper(index + 1, max, left, right + 1, chs, ans);
            return;
        }
    }

}
