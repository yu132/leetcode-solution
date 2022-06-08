package redo.offer2.p05;

import org.junit.Assert;
import org.junit.Test;
import redo.Util.Bits;

/**  
 * @ClassName: P05_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P05_01 {

    class Solution {
        public int insertBits(int N, int M, int i, int j) {
            int mask = (1 << (j - i + 1)) - 1;
            return (N & (~(mask << i))) | (M << i);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        System.out.println(Bits.toBinaryStr(2032243561));
        System.out.println(Bits.toBinaryStr(10 << 24));
        System.out.println(Bits.toBinaryStr(1243714409));
        Assert.assertEquals(1243714409, s.insertBits(2032243561, 10, 24, 29));
    }

}
