package redo.p0800_0899;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P869  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P869 {

    static//

    class Solution {
        public boolean reorderedPowerOf2(int N) {
            int[] count = digitsCount(N);
            for (int i = 1; i != 0x80000000; i <<= 1) {
                if (Arrays.equals(count, digitsCount(i))) {
                    return true;
                }
            }
            return false;
        }

        public static int[] digitsCount(int num) {
            int[] count = new int[10];
            if (num == 0) {
                ++count[0];
                return count;
            }
            while (num != 0) {
                ++count[num % 10];
                num /= 10;
            }
            return count;
        }
    }

    // static//
    //
    // class Solution {
    //
    // public boolean reorderedPowerOf2(int N) {
    // return backtrace(0, digitsCount(N), N);
    // }
    //
    // boolean backtrace(int index, int len, int num) {
    // if (index == len) {
    // return digitsCount(num) == len && (num & (num - 1)) == 0;
    // }
    // for (int i = index; i < len; ++i) {
    // int nn = swap(num, index, i);
    // if ((i == index || nn != num) && backtrace(index + 1, len, nn)) {
    // return true;
    // }
    // }
    // return false;
    // }
    //
    // final static int[] UTILS = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    //
    // // 交换十进制int值的两位，0从低位开始计算，即从右往左数
    // static int swap(int num, int x, int y) {
    // return num + (num / UTILS[x]) % 10 * (UTILS[y] - UTILS[x]) + (num / UTILS[y]) % 10 * (UTILS[x] - UTILS[y]);
    // }
    //
    // public static int digitsCount(int num) {
    // int digits = 1;
    // while (num != 0) {
    // ++digits;
    // num /= 10;
    // }
    // return digits;
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.reorderedPowerOf2(1));
        Assert.assertEquals(false, s.reorderedPowerOf2(10));
        Assert.assertEquals(true, s.reorderedPowerOf2(16));
        Assert.assertEquals(false, s.reorderedPowerOf2(24));
        Assert.assertEquals(true, s.reorderedPowerOf2(46));
        Assert.assertEquals(false, s.reorderedPowerOf2(116617277));
    }

}
