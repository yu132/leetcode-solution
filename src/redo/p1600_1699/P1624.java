package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1624  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1624 {

    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int[] max = new int[26];
            int ans = 0;
            for (int i = 0; i < s.length(); ++i) {
                max[s.charAt(i) - 'a'] = i;
            }
            for (int i = 0; i < s.length(); ++i) {
                ans = Math.max(ans, max[s.charAt(i) - 'a'] - i);
            }
            return ans - 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.maxLengthBetweenEqualCharacters("aa"));
        Assert.assertEquals(2, s.maxLengthBetweenEqualCharacters("abca"));
        Assert.assertEquals(-1, s.maxLengthBetweenEqualCharacters("cbzxy"));
        Assert.assertEquals(4, s.maxLengthBetweenEqualCharacters("cabbac"));
    }

}
