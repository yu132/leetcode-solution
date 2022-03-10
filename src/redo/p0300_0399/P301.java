package redo.p0300_0399;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: P301  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P301 {

    class Solution {
        public List<String> removeInvalidParentheses(String s) {

            Set<String> ans = new HashSet<>();

            int l = 0, r = 0;

            char[] chs = s.toCharArray();

            for (char ch : chs) {
                if (ch == '(') {
                    ++l;
                } else if (ch == ')') {
                    if (l == 0) {
                        ++r;
                    } else {
                        --l;
                    }
                }
            }
            backtrack(l, r, 0, 0, chs, 0, new char[s.length() - l - r], ans);

            return new ArrayList<>(ans);
        }

        void backtrack(int l, int r, int cl, int index, char[] chs, int i2,
            char[] ansArr, Set<String> ans) {
            if (index == chs.length) {
                if (i2 == ansArr.length) {
                    ans.add(String.valueOf(ansArr));
                }
                return;
            }
            if (chs[index] == '(') {
                if (l > 0) {
                    backtrack(l - 1, r, cl, index + 1, chs, i2, ansArr, ans);
                }
                if (i2 == ansArr.length) {
                    return;
                }
                ansArr[i2] = '(';
                backtrack(l, r, cl + 1, index + 1, chs, i2 + 1, ansArr, ans);
            } else if (chs[index] == ')') {
                if (r > 0) {
                    backtrack(l, r - 1, cl, index + 1, chs, i2, ansArr, ans);
                }
                if (cl > 0) {
                    if (i2 == ansArr.length) {
                        return;
                    }
                    ansArr[i2] = ')';
                    backtrack(l, r, cl - 1, index + 1, chs, i2 + 1, ansArr,
                        ans);
                }
            } else {
                if (i2 == ansArr.length) {
                    return;
                }
                ansArr[i2] = chs[index];
                backtrack(l, r, cl, index + 1, chs, i2 + 1, ansArr, ans);
            }
        }
    }

}
