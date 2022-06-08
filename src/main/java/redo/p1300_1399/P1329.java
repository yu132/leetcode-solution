package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1329  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1329 {

    static//

    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            for (int i = 0; i < mat.length; ++i) {
                countSort(new Diagonal(mat, i, 0), 0, 101);
            }
            for (int i = 1; i < mat[0].length; ++i) {
                countSort(new Diagonal(mat, 0, i), 0, 101);
            }
            return mat;
        }

        // public static void insertSort(IntMockArray arr) {
        // for (int i = 1; i < arr.size(); ++i) {
        // int num = arr.get(i), j = i;
        // while (j > 0 && arr.get(j - 1) > num) {
        // arr.set(j, arr.get(j - 1));
        // --j;
        // }
        // arr.set(j, num);
        // }
        // }
        public static void countSort(IntMockArray arr, int start, int end) {
            int[] count = count(arr, start, end);

            for (int i = 0, index = 0; i < end - start; ++i) {
                for (int j = 0; j < count[i]; ++j) {
                    arr.set(index++, start + i);
                }
            }
        }

        public static int[] count(IntMockArray nums, int start, int end) {
            int[] count = new int[end - start];
            for (int i = 0; i < nums.size(); ++i) {
                ++count[nums.get(i) - start];
            }
            return count;
        }

        static interface IntMockArray {
            int size();

            int get(int index);

            int set(int index, int val);
        }

        static class Diagonal implements IntMockArray {

            int[][] mat;
            int x, y;

            public Diagonal(int[][] mat, int x, int y) {
                super();
                this.mat = mat;
                this.x = x;
                this.y = y;
            }

            @Override
            public int size() {
                return Math.min(mat.length - x, mat[0].length - y);
            }

            @Override
            public int get(int index) {
                return mat[x + index][y + index];
            }

            @Override
            public int set(int index, int val) {
                return mat[x + index][y + index] = val;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,1,1,1],[1,2,2,2],[1,2,3,3]]",
            Arrs.toStr(s.diagonalSort(Arrs.build2D("[[3,3,1,1],[2,2,1,2],[1,1,1,2]]"))));
    }

}
