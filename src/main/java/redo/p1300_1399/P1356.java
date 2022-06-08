package redo.p1300_1399;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1356  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1356 {

    class Solution {
        public int[] sortByBits(int[] arr) {
            sort(arr, (a, b) -> {
                int aBitCount = Integer.bitCount(a);
                int bBitCount = Integer.bitCount(b);
                if (aBitCount == bBitCount) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(aBitCount, bBitCount);
            });
            return arr;
        }

        public void sort(int[] arr, Comparator<Integer> comparator) {
            Integer[] copy = new Integer[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                copy[i] = arr[i];
            }
            Arrays.sort(copy, comparator);
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = copy[i];
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 8, 3, 5, 6, 7},
            s.sortByBits(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}));
        Assert.assertArrayEquals(new int[] {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024},
            s.sortByBits(new int[] {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
        Assert.assertArrayEquals(new int[] {10000, 10000}, s.sortByBits(new int[] {10000, 10000}));
        Assert.assertArrayEquals(new int[] {2, 3, 5, 17, 7, 11, 13, 19},
            s.sortByBits(new int[] {2, 3, 5, 7, 11, 13, 17, 19}));
        Assert.assertArrayEquals(new int[] {10, 100, 10000, 1000}, s.sortByBits(new int[] {10, 100, 10000, 1000}));
    }

}
