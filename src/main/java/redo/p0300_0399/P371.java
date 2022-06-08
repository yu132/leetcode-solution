package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import redo.Util.Bits;

/**  
 * @ClassName: P371  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P371 {

    class Solution {
        public int getSum(int a, int b) {
            while (b != 0) {// 进位为0时退出
                int temp = a ^ b;// 二进制和
                b = (a & b) << 1;// 进位
                a = temp;
            }
            return a;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.getSum(1, 2));
        assertEquals(1, s.getSum(-2, 3));
        assertEquals(-7, s.getSum(-10, 3));
        System.out.println(Bits.toBinaryStr(-2));
    }

}
