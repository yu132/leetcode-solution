package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1408  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1408 {

    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> ans = new ArrayList<>();
            boolean[] visited = new boolean[words.length];
            for (int i = 0; i < words.length; ++i) {
                for (int j = i + 1; j < words.length; ++j) {
                    if (words[i].length() == words[j].length()) {
                        continue;
                    }
                    if (!visited[j] && words[i].contains(words[j])) {
                        ans.add(words[j]);
                        visited[j] = true;
                    }
                    if (!visited[i] && words[j].contains(words[i])) {
                        ans.add(words[i]);
                        visited[i] = true;
                    }
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("as", "hero"),
            s.stringMatching(new String[] {"mass", "as", "hero", "superhero"}));
        Assert.assertEquals(Arrays.asList("et", "code"), s.stringMatching(new String[] {"leetcode", "et", "code"}));
        Assert.assertEquals(Arrays.asList(), s.stringMatching(new String[] {"blue", "green", "bu"}));
        Assert.assertEquals(Arrays.asList("leetcode", "od", "am"),
            s.stringMatching(new String[] {"leetcoder", "leetcode", "od", "hamlet", "am"}));

        Assert.assertEquals(Arrays.asList("od", "leetcode", "am"),
            s.stringMatching(new String[] {"od", "leetcoder", "leetcode", "hamlet", "am"}));
    }

}
