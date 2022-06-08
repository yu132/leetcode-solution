package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P890  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月26日  
 *  
 */
public class P890 {

    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {

            List<String> ans = new ArrayList<>();

            outer:
            for (String word : words) {
                char[] map = new char[26];
                for (int i = 0; i < word.length(); ++i) {
                    if (map[word.charAt(i) - 'a'] == 0) {
                        map[word.charAt(i) - 'a'] = pattern.charAt(i);
                    } else {
                        if (map[word.charAt(i) - 'a'] != pattern.charAt(i)) {
                            continue outer;
                        }
                    }
                }

                Arrays.sort(map);
                for (int i = 1; i < 26; ++i) {
                    if (map[i] == map[i - 1] && map[i] != 0) {
                        continue outer;
                    }
                }

                ans.add(word);
            }

            return ans;
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("mee", "aqq"),
            s.findAndReplacePattern(new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

}
