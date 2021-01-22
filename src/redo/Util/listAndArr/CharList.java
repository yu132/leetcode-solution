package redo.Util.listAndArr;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: CharsList  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class CharList {

    public static void arrayRotationBackward(char[] array, int from, int length, int k) {
        k %= length;
        reverse(array, from, from + length - k - 1);
        reverse(array, from + length - k, from + length - 1);
        reverse(array, from, from + length - 1);
    }

    public static void reverse(char[] array, int from, int to) {
        for (; from < to; ++from, --to) {
            swap(array, from, to);
        }
    }

    public static void swap(char[] array, int x, int y) {
        char num = array[x];
        array[x] = array[y];
        array[y] = num;
    }

    @Test
    public void test() {
        char[] chs = "1234567890".toCharArray();
        arrayRotationBackward(chs, 0, chs.length, 2);
        assertArrayEquals("9012345678".toCharArray(), chs);
    }

    @Test
    public void test1() {
        char[] chs = "12".toCharArray();
        arrayRotationBackward(chs, 0, chs.length, 5);
        assertArrayEquals("21".toCharArray(), chs);
    }

}
