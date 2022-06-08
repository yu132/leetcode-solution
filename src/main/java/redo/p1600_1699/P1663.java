package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1663  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1663 {

    class Solution {
        public String getSmallestString(int n, int k) {
            k -= n;
            char[] chs = new char[n];
            int index = n - 1;
            while (k >= 25) {
                chs[index--] = 'z';
                k -= 25;
            }
            if (index < 0) {
                return String.valueOf(chs);
            }
            chs[index--] = (char)('a' + k);
            while (index >= 0) {
                chs[index--] = 'a';
            }
            return String.valueOf(chs);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("aay", s.getSmallestString(3, 27));
        Assert.assertEquals("aaszz", s.getSmallestString(5, 73));
        Assert.assertEquals("zzzzz", s.getSmallestString(5, 130));
    }

}
