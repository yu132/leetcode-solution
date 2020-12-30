package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1446  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1446 {

    class Solution {
        public int maxPower(String s) {
            if (s.length() == 0) {
                return 0;
            }
            s += '\0';
            char last = '\0';
            int count = 0, max = 0;
            for (char ch : s.toCharArray()) {
                if (ch == last) {
                    ++count;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
                last = ch;
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxPower("leetcode"));
        Assert.assertEquals(5, s.maxPower("abbcccddddeeeeedcba"));
        Assert.assertEquals(5, s.maxPower("triplepillooooow"));
        Assert.assertEquals(11, s.maxPower("hooraaaaaaaaaaay"));
        Assert.assertEquals(1, s.maxPower("tourist"));
        Assert.assertEquals(0, s.maxPower(""));
    }

}
