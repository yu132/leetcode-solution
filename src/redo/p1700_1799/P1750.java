package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1750  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1750 {

    class Solution {
        public int minimumLength(String s) {
            int low = 0, high = s.length() - 1;
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    return high - low + 1;
                }

                while (low < high && s.charAt(low) == s.charAt(low + 1)) {
                    ++low;
                }
                ++low;
                while (low < high && s.charAt(high) == s.charAt(high - 1)) {
                    --high;
                }
                --high;
            }
            if (low == high) {
                return 1;
            } else {
                return 0;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.minimumLength("cabaabac"));
        Assert.assertEquals(3, s.minimumLength("aabccabba"));
        Assert.assertEquals(1, s.minimumLength("a"));
        Assert.assertEquals(1, s.minimumLength("cac"));
        Assert.assertEquals(0, s.minimumLength("aaa"));
    }
}
