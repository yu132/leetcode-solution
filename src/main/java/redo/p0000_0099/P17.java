package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: P17  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月21日  
 *  
 */
public class P17 {

    class Solution {

        String[] table = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return Collections.emptyList();
            }
            int n = digits.length();
            char[] digit = digits.toCharArray();
            List<String> ans = new ArrayList<>();
            backtrack(0, digit, new char[n], new boolean[n], ans);
            return ans;
        }

        void backtrack(int index, char[] digits, char[] chs, boolean[] used,
            List<String> ans) {
            if (index == digits.length) {
                ans.add(String.valueOf(chs));
                return;
            }
            for (char ch : table[digits[index] - '0'].toCharArray()) {
                chs[index] = ch;
                backtrack(index + 1, digits, chs, used, ans);
            }
        }
    }

}
