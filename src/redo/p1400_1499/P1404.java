package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1404  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1404 {

    /*
     * "1101010011101"1
     * "1101010011110"2
     * "0110101001111"3
     * "0110101010000"4
     * "0011010101000"5
     * "0001101010100"6
     * "0000110101010"7
     * "0000011010101"8
     * "0000011010110"9
     * "0000001101011"10
     * "0000001101100"11
     * "0000000110110"12
     * "0000000011011"13
     * "0000000011100"14
     * "0000000001110"15
     * "0000000000111"16
     * "0000000001000"17
     * "0000000000100"18
     * "0000000000010"19
     * "0000000000001"20
     * 
     * 等价于
     * "1101010011101"1
     * "1101010011110"2
     * "1101010100000"3
     * "1101011000000"4
     * "1101100000000"5
     * "1110000000000"6
     * "0000000000000"7 + 长度"00000 00000 000" 13
     * 
     * 此过程又等价于0的数量+1
     */

    class Solution {
        public int numSteps(String s) {
            int j = s.length() - 1, count = 0, c0 = 0, c1 = 0, len;
            for (; s.charAt(j) != '1'; --j) {// 去掉尾部0，因为需要保持1[01]*1的样式，必须保证首尾都为1
                ++count;
            }
            len = j + 1;// 右移的数量，由于总是+1后变为1[0]*的样式，最终都需要右移，并且右移长度和len相等
            for (; j >= 0; --j) {// 计算0的数量
                if (s.charAt(j) == '0') {// 0就是左加的数量，对于每个1前面0，都需要通过+1消除，最终变为连续的1
                    ++c0; // 然后再+1变为1右边的0
                } else {
                    ++c1;
                }
            }
            if (c1 == 1) {// 处理仅有1个1的特殊情况
                return count + c0;
            }
            return count + c0 + 1 + len;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.numSteps("1101"));
        Assert.assertEquals(27, s.numSteps("10000000000001"));
        Assert.assertEquals(0, s.numSteps("1"));
        Assert.assertEquals(12, s.numSteps("11111111111"));
        Assert.assertEquals(1, s.numSteps("10"));
        Assert.assertEquals(21, s.numSteps("11111111111000000000"));
        Assert.assertEquals(27, s.numSteps("11111100011111000000000"));
    }



}
