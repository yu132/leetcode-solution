package redo.Util;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: Integers  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class Integers {

    // 数字的位数
    public static int len(int num) {
        if (num == 0) {
            return 1;
        }
        int digits = 0;
        while (num != 0) {
            ++digits;
            num /= 10;
        }
        return digits;
    }

    public static boolean isPalindrome(int num) {
        return reverse(num) == num;
    }

    public static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    // 计算每位上0-9的总个数
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

    // 按位求和
    public static int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    final static int[] UTILS = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    // 交换十进制int值的两位，0从低位开始计算，即从右往左数
    static int swap(int num, int x, int y) {
        return num + (num / UTILS[x]) % 10 * (UTILS[y] - UTILS[x]) + (num / UTILS[y]) % 10 * (UTILS[x] - UTILS[y]);
    }



    @Test
    public void testSwap() {
        Assert.assertEquals(123, swap(321, 0, 2));
        Assert.assertEquals(645643563, swap(665643543, 1, 7));
    }

}
