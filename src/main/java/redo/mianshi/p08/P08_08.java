package redo.mianshi.p08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P08_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_08 {

    class Solution {
        public String[] permutation(String S) {
            List<String> ans = new ArrayList<>();
            int n = S.length();
            char[] src = S.toCharArray();
            Arrays.sort(src);
            backtrack(0, new char[n], src, ans, new boolean[n]);
            return ans.toArray(new String[0]);
        }

        void backtrack(int index, char[] chs, char[] src, List<String> ans,
            boolean[] used) {
            if (index == chs.length) {
                ans.add(String.valueOf(chs));
                return;
            }

            for (int i = 0; i < src.length; ++i) {
                if ((i == 0 || src[i - 1] != src[i] || used[i - 1])
                    && !used[i]) {
                    chs[index] = src[i];
                    used[i] = true;
                    backtrack(index + 1, chs, src, ans, used);
                    used[i] = false;
                }
            }
        }
    }

}
