package redo.p0100_0199;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: P190  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P190 {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            n = (n >>> 16) | (n << 16);
            n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
            n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
            n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
            n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
            return n;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(-1073741825, s.reverseBits(-3));
    }
}
