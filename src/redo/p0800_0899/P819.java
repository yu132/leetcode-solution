package redo.p0800_0899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P819  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P819 {

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = new HashSet<>();
            bannedSet.add("");
            for (String str : banned) {
                bannedSet.add(str);
            }
            Map<String, Integer> counter = new HashMap<>();
            for (String str : paragraph.split("[ !?',;.]")) {
                str = str.toLowerCase();
                if (bannedSet.contains(str)) {
                    continue;
                }
                counter.put(str, counter.getOrDefault(str, 0) + 1);
            }
            int max = -1;
            String str = null;
            for (Map.Entry<String, Integer> entry : counter.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    str = entry.getKey();
                }
            }
            return str;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("ball",
            s.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }

}
