package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1540  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1540 {

    class Solution {
        public boolean canConvertString(String s, String t, int k) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                ++count[(t.charAt(i) - s.charAt(i) + 26) % 26];
            }
            int max = 0, maxIndex = 0;
            for (int i = 1; i < count.length; ++i) {
                if (count[i] >= max) {
                    max = count[i];
                    maxIndex = i;
                }
            }
            return (max - 1) * 26 + maxIndex <= k;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canConvertString("input", "ouput", 9));
        Assert.assertEquals(false, s.canConvertString("abc", "bcd", 10));
        Assert.assertEquals(true, s.canConvertString("aab", "bbb", 27));
        Assert.assertEquals(false, s.canConvertString("jicfxaa", "ocxltbp", 15));
    }

}
