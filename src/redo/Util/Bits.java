package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: Bits  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class Bits {

    public final static int OX_FFFF0000 = of("11111111111111110000000000000000");
    public final static int OX_0000FFFF = of("00000000000000001111111111111111");

    public final static int OX_FF00FF00 = of("11111111000000001111111100000000");
    public final static int OX_00FF00FF = of("00000000111111110000000011111111");

    public final static int OX_F0F0F0F0 = of("11110000111100001111000011110000");
    public final static int OX_0F0F0F0F = of("00001111000011110000111100001111");

    public final static int OX_CCCCCCCC = of("11001100110011001100110011001100");
    public final static int OX_33333333 = of("00110011001100110011001100110011");

    public final static int OX_AAAAAAAA = of("10101010101010101010101010101010");
    public final static int OX_55555555 = of("01010101010101010101010101010101");

    public final static int OX_00000001 = of("00000000000000000000000000000001");

    public static int of(String str) {
        if (str.length() != 32) {
            throw new IllegalArgumentException("长度不为32位");
        }
        return Integer.parseUnsignedInt(str, 2);
    }

    public static String toBinaryStr(int num) {
        // return fill32(Integer.toBinaryString(num));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; ++i) {
            sb.append(num & 0x1);
            num >>>= 1;
        }
        return sb.reverse().toString();
    }

    // private static String fill32(String str) {
    // if (str.length() < 32) {
    // StringBuilder sb = new StringBuilder(32 - str.length());
    // while (32 - sb.length() - str.length() > 0) {
    // sb.append(0);
    // }
    // str = sb.append(str).toString();
    // }
    // return str;
    // }

    /*
     * example:
     * num  :00000100000000010000000100000000
     * num-1:00000100000000010000000011111111
     *     &:00000100000000010000000000000000 
     */
    public static int removeLast1(int num) {
        return num & (num - 1);
    }

    /* 
     * 返回最后一个1对应的二进制位为1的数
     * 如   :00100100101010010010010101100010
     * 返回:00000000000000000000000000000010
     * 
     * way1: num ^ removeLast1(num);
     * example:
     * num             :00000100000000010000000100000000
     * removeLast1(num):00000100000000010000000000000000
     *                ^:00000000000000000000000100000000
     *                
     * way2: num & (~(num - 1));
     * example:
     * num    :00000100000000010000000100000000
     * 
     * num - 1:00000100000000010000000011111111
     *       ~:11111011111111101111111100000000
     *       
     * num       :00000100000000010000000100000000
     * ~(num - 1):11111011111111101111111100000000    
     *          &:00000000000000000000000100000000
     *          
     * 因为 -num == ~(num - 1) "减一求反" == ~num + 1  "求反加一"
     */
    public static int getLast1(int num) {
        // return num ^ removeLast1(num);
        // return num & (~(num - 1));
        // return num & (-num);
        return Integer.lowestOneBit(num);
    }

    /* 
     * 返回第一个1对应的二进制位为1的数
     * 如   :00100100101010010010010101100010
     * 返回:00100000000000000000000000000000
     */
    public static int getFirst1(int num) {
        // int pos = 1;
        // if ((num & 0xFFFF0000) != 0) {
        // num >>>= 16;
        // pos <<= 16;
        // }
        // if ((num & 0x0000FF00) != 0) {
        // num >>>= 8;
        // pos <<= 8;
        // }
        // if ((num & 0x000000F0) != 0) {
        // num >>>= 4;
        // pos <<= 4;
        // }
        // if ((num & 0x0000000C) != 0) {
        // num >>>= 2;
        // pos <<= 2;
        // }
        // if ((num & 0x00000002) != 0) {
        // num >>>= 1;
        // pos <<= 1;
        // }
        // return (num & 1) == 0 ? 0 : pos;
        return Integer.highestOneBit(num);
    }

    // 计算二进制1的个数
    public int count1Num(int num) {
        // int count = 0;
        // while (num != 0) {
        // num &= num - 1;
        // ++count;
        // }
        // return count;
        return Integer.bitCount(num);
    }

    // 计算二进制数的长度
    public int bitLen(int num) {
        int temp, len = 0;
        if ((temp = num >>> 16) != 0) {
            num = temp;
            len += 16;
        }
        if ((temp = num >>> 8) != 0) {
            num = temp;
            len += 8;
        }
        if ((temp = num >>> 4) != 0) {
            num = temp;
            len += 4;
        }
        if ((temp = num >>> 2) != 0) {
            num = temp;
            len += 2;
        }
        if ((temp = num >>> 1) != 0) {
            num = temp;
            len += 1;
        }
        if (num == 1) {
            len += 1;
        }
        return len;
    }

    public int negative(int num) {
        return add(~num, 1);
    }

    /*
     * 原理就是每次获取num和进位的二进制和和新的进位，然后继续相加，直至进位为0
     * 
     * 对于两个数都为正数来说，用 异或 获取 二进制和 和 与+左移 获取 进位 是显而易见成立的
     * 
     * 对于负数为何也成立，这是因为无论正负数在计算机内都用补码存储，正数补码和原码相同
     * 负数则为求反加一
     * 
     * 例如 3 + -2 = 1
     *  3:00000000000000000000000000000011
     * -2:11111111111111111111111111111110
     *  +:00000000000000000000000000000001
     *  
     *  当正数>负数时，由于溢出进位，保证了结果为正
     *  当正数<负数时，不足以完成最高位的进位，因此结果为负
     *  
     *  补码保证了无论数的正负，都能使用相同的方法完成加法运算
     */
    public int add(int num, int inc) {
        while (inc != 0) {// 进位为0时退出
            int temp = num ^ inc;// 二进制和
            inc = (num & inc) << 1;// 进位
            num = temp;
        }
        return num;
    }

    public int minus(int a, int b) {
        return add(a, negative(b));
    }

    /*
     * 本方法用于将最高位1左边的所有位置填充为1，一般用于生成屏蔽前导0时的掩码
     * 
     * 运算逻辑是这样的，就是通过不断的复制最高位的1，将低位全部填满
     * example:
     *     num :00010000000000000000000000000000
     *  |=>>>1 :00011000000000000000000000000000
     *  |=>>>2 :00011110000000000000000000000000
     *  |=>>>4 :00011111111000000000000000000000
     *  |=>>>8 :00011111111111111110000000000000
     *  |=>>>16:00011111111111111111111111111111
     *  
     * 例子中只有最高位为1，但是无论低位为0或者1，都没有影响，因为是做|运算
     */
    public int fillLower(int num) {
        num |= num >>> 1;
        num |= num >>> 2;
        num |= num >>> 4;
        num |= num >>> 8;
        num |= num >>> 16;
        return num;
    }

    @Test
    public void test() {
        assertEquals(0XFFFF0000, OX_FFFF0000);
        assertEquals(0X0000FFFF, OX_0000FFFF);

        assertEquals(0XFF00FF00, OX_FF00FF00);
        assertEquals(0X00FF00FF, OX_00FF00FF);

        assertEquals(0XF0F0F0F0, OX_F0F0F0F0);
        assertEquals(0X0F0F0F0F, OX_0F0F0F0F);

        assertEquals(0XCCCCCCCC, OX_CCCCCCCC);
        assertEquals(0X33333333, OX_33333333);

        assertEquals(0XAAAAAAAA, OX_AAAAAAAA);
        assertEquals(0X55555555, OX_55555555);

        assertEquals(0X00000001, OX_00000001);

        assertEquals("00000100000000010000000000000000", toBinaryStr(of("00000100000000010000000000000000")));
    }

    @Test
    public void test1() {
        assertEquals(of("00000100000000010000000000000000"), removeLast1(of("00000100000000010000000100000000")));
        assertEquals(of("00000000000000000000000100000000"), getLast1(of("00000100000000010000000100000000")));

        assertEquals(of("00000100000000000000000000000000"), getFirst1(of("00000100000000010000000100000000")));
        assertEquals(of("00100000000000000000000000000000"), getFirst1(of("00100100101010010010010101100010")));
        assertEquals(of("00000000000000000000000000000010"), getFirst1(of("00000000000000000000000000000011")));
        assertEquals(of("00000000000000000010000000000000"), getFirst1(of("00000000000000000010000000000011")));
        assertEquals(of("00000000000000000000000000000001"), getFirst1(of("00000000000000000000000000000001")));
        assertEquals(of("00000000000000000000000000000000"), getFirst1(of("00000000000000000000000000000000")));
        assertEquals(of("10000000000000000000000000000000"), getFirst1(of("10100100101010010010010101100010")));

        assertEquals(32, count1Num(-1));
    }

    // @Test //为正确，比较耗时
    public void test2() {
        for (long x = Integer.MIN_VALUE; x <= Integer.MAX_VALUE; ++x) {
            int i = (int)x;
            assertEquals(-i, ~(i - 1));
            assertEquals(-i, ~i + 1);
        }
    }

    @Test
    public void test3() {
        assertEquals(-1, negative(1));
        assertEquals(-46521485, negative(46521485));
        assertEquals(3, add(1, 2));
        assertEquals(18645165 + 2488949, add(18645165, 2488949));
        assertEquals(-18645165 + 2488949, add(-18645165, 2488949));
        assertEquals(18645165 - 2488949, add(18645165, -2488949));

        assertEquals(18645165 - 2488949, minus(18645165, 2488949));
        assertEquals(-18645165 - 2488949, minus(-18645165, 2488949));
        assertEquals(18645165 + 2488949, minus(18645165, -2488949));
    }

    @Test
    public void test4() {
        assertEquals(32, bitLen(of("10000000000000000000000000000000")));
        assertEquals(31, bitLen(of("01000000000000000000000000000000")));
        assertEquals(17, bitLen(of("00000000000000011000000000000000")));
        assertEquals(4, bitLen(of("00000000000000000000000000001000")));
    }
}
