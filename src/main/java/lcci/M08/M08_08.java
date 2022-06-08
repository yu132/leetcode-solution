package lcci.M08;

import java.util.HashSet;

/**  
 * @ClassName: M08_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月5日  
 *  
 */
public class M08_08 {

    class Solution {
        public String[] permutation(String S) {
            HashSet<String> ans = new HashSet<>();
            helper(0, S.toCharArray(), ans);
            return ans.toArray(new String[ans.size()]);
        }

        public void helper(int index, char[] chs, HashSet<String> ans) {
            if (index == chs.length) {
                ans.add(String.valueOf(chs));
                return;
            }
            for (int i = index; i < chs.length; ++i) {
                char temp = chs[index];
                chs[index] = chs[i];
                chs[i]     = temp;
                helper(index + 1, chs, ans);
                temp       = chs[index];
                chs[index] = chs[i];
                chs[i]     = temp;
            }
        }
    }

}
