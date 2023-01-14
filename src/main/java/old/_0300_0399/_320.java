package old._0300_0399;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _320  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月10日  
 *  
 */
public class _320 {

    class Solution {
        public List<String> generateAbbreviations(String word) {

            List<String> ans = new ArrayList<>();

            dfs(0, new boolean[word.length()], word, ans);

            return ans;
        }

        public void dfs(int index, boolean[] flag, String word, List<String> ans) {
            if (index == word.length()) {
                int           f      = 0;
                boolean       isAbbr = false;
                StringBuilder sb     = new StringBuilder(word.length());
                for (int i = 0; i < word.length(); ++i) {
                    if (flag[i]) {
                        if (!isAbbr) {
                            isAbbr = true;
                            sb.append(word.substring(f, i));
                            f = i;
                        }
                    } else {
                        if (isAbbr) {
                            isAbbr = false;
                            sb.append(i - f);
                            f = i;
                        }
                    }
                }
                if (isAbbr) {
                    sb.append(word.length() - f);
                } else {
                    sb.append(word.substring(f, word.length()));
                }
                ans.add(sb.toString());
                return;
            }
            flag[index] = false;
            dfs(index + 1, flag, word, ans);
            flag[index] = true;
            dfs(index + 1, flag, word, ans);
        }
    }

}
