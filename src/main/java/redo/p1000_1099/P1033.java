package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1033  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1033 {

    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] arr = new int[] {a, b, c};
            Arrays.sort(arr);
            return new int[] {min(arr[0], arr[1], arr[2]), max(arr[0], arr[1]) + max(arr[1], arr[2])};
        }

        public int min(int x, int y, int z) {
            if (x == y - 2 || y == z - 2) {
                return 1;
            } else {
                return min(x, y) + min(y, z);
            }
        }

        public int min(int x, int y) {
            return Math.min(y - x, 2) - 1;
        }

        public int max(int x, int y) {
            return y - x - 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 2}, s.numMovesStones(1, 2, 5));
        Assert.assertArrayEquals(new int[] {0, 0}, s.numMovesStones(4, 3, 2));
        Assert.assertArrayEquals(new int[] {2, 99 + 5123 - 201}, s.numMovesStones(100, 200, 5123));
        Assert.assertArrayEquals(new int[] {1, 2}, s.numMovesStones(5, 3, 1));
    }

}
