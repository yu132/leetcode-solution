package redo.p1400_1499;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1371  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1371 {

    class Solution {

        public int findTheLongestSubstring(String s) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            int oddTag = 0, ans = 0;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (isLowercaseVowel(ch)) {
                    oddTag ^= 1 << map(ch);
                }
                if (map.containsKey(oddTag)) {
                    ans = Math.max(ans, i - map.get(oddTag));
                }
                map.putIfAbsent(oddTag, i);
            }
            return ans;
        }

        public boolean isLowercaseVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }

        int map(char ch) {
            switch (ch) {
                case 'a':
                    return 0;
                case 'e':
                    return 1;
                case 'i':
                    return 2;
                case 'o':
                    return 3;
                case 'u':
                    return 4;
            }
            throw new RuntimeException("unreachable");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.findTheLongestSubstring("eleetminicoworoep"));
        Assert.assertEquals(5, s.findTheLongestSubstring("leetcodeisgreat"));
        Assert.assertEquals(6, s.findTheLongestSubstring("bcbcbc"));
    }
}
