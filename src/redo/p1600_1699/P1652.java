package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1652  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1652 {

    static//

    class Solution {
        public int[] decrypt(int[] code, int k) {
            int len = Math.abs(k), sum = 0;
            for (int i = 0; i < len; ++i) {
                sum += code[i];
            }
            int[] sumLen = new int[code.length];
            sumLen[0] = sum;
            for (int i = 1; i < code.length; ++i) {
                sum -= code[i - 1];
                sum += code[(i + len - 1) % code.length];
                sumLen[i] = sum;
            }
            if (k > 0) {
                arrayRotation(sumLen, 0, sumLen.length, 1);
            }
            if (k < 0) {
                arrayRotation(sumLen, 0, sumLen.length, code.length + k);
            }
            return sumLen;
        }

        public static void arrayRotation(int[] array, int from, int length, int k) {
            k %= length;
            reverse(array, from, from + k - 1);
            reverse(array, from + k, from + length - 1);
            reverse(array, from, from + length - 1);
        }

        public static void reverse(int[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                swap(array, from, to);
            }
        }

        public static void swap(int[] array, int x, int y) {
            int num = array[x];
            array[x] = array[y];
            array[y] = num;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {12, 10, 16, 13}, s.decrypt(new int[] {5, 7, 1, 4}, 3));
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0}, s.decrypt(new int[] {1, 2, 3, 4}, 0));
        Assert.assertArrayEquals(new int[] {12, 5, 6, 13}, s.decrypt(new int[] {2, 4, 9, 3}, -2));
        Assert.assertArrayEquals(new int[] {22, 26, 22, 28, 29, 22, 19, 22, 18, 21, 28, 19},
            s.decrypt(new int[] {10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4));
    }

}
