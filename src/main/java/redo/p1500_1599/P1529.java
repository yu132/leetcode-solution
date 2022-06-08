package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1529  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1529 {

    /*
    *  "001011101" 
    *  "000100010" 
    *  "000011101" 
    *  "000000010" 
    *  "000000001" 
    *  "000000000" 
    */

    class Solution {
        public int minFlips(String target) {
            char last = '0';
            int ans = 0;
            for (char ch : target.toCharArray()) {
                if (ch != last) {
                    ++ans;
                    last = ch;
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minFlips("10111"));
        Assert.assertEquals(3, s.minFlips("101"));
        Assert.assertEquals(0, s.minFlips("00000"));
        Assert.assertEquals(5, s.minFlips("001011101"));
    }

}
