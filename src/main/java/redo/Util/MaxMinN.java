package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Test;

/**  
 * @ClassName: MaxN  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class MaxMinN {

    // O(n*k) 当k比较小的时候可以使用，k比较大的时候建议使用

    // [0] min -3,-2,-1 小到大
    // [1] max 3,2,1 大到小
    public int[][] maxMinN(int[] arr, int k) {
        int[] max = new int[k], min = new int[k];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int num : arr) {
            for (int i = 0; i < max.length; ++i) {
                if (num >= max[i]) {
                    System.arraycopy(max, i, max, i + 1, max.length - i - 1);
                    max[i] = num;
                    break;
                }
            }
            for (int i = 0; i < min.length; ++i) {
                if (num <= min[i]) {
                    System.arraycopy(min, i, min, i + 1, min.length - i - 1);
                    min[i] = num;
                    break;
                }
            }
        }
        return new int[][] {min, max};
    }

    @Test
    public void test() {
        assertEquals("[[-3,-2,-1],[3,2,1]]",
            Arrays
                .deepToString(
                    maxMinN(new int[] {1, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, -1, -1, -1, 0, 0, -2, -3, 0, 0}, 3))
                .replaceAll("\\s", ""));

    }

}
