package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import redo.Util.Bits;

/**  
 * @ClassName: P191  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P191 {

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int num = 0;
            for (int i = 0; i < 32; ++i) {
                num += (0x00000001 & n);
                n >>>= 1;
            }
            return num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.hammingWeight(Bits.of("00000000000000000000000000001011")));
        assertEquals(1, s.hammingWeight(Bits.of("00000000000000000000000010000000")));

        assertEquals(32, s.hammingWeight(Bits.of("11111111111111111111111111111111")));
    }

}
