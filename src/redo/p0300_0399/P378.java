package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P378  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P378 {

    static//

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            return minK(matrix, k);
        }

        public static int minK(int[][] matrix, int k) {
            int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];

            while (low < high) {
                int mid = (low + high) >>> 1;
                if (countLittleThanNum(matrix, mid) >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public static int countLittleThanNum(int[][] matrix, int num) {
            int x = matrix.length - 1, y = 0, count = 0;
            while (x >= 0 && y < matrix[0].length) {
                if (matrix[x][y] <= num) {
                    count += x + 1;
                    ++y;
                } else {
                    --x;
                }
            }
            return count;
        }
    }



    // class Solution {
    // public int kthSmallest(int[][] matrix, int k) {
    // int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
    //
    // while (low < high) {
    // int mid = (low + high) >>> 1;
    // if (check(matrix, k, mid)) {
    // high = mid;
    // } else {
    // low = mid + 1;
    // }
    // }
    // return low;
    // }
    //
    // private boolean check(int[][] matrix, int k, int num) {
    // int n = matrix.length, x = n - 1, y = 0, count = 0;
    // while (x >= 0 && y < n) {
    // if (matrix[x][y] <= num) {
    // count += x + 1;
    // ++y;
    // } else {
    // --x;
    // }
    // }
    // return count >= k;
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.kthSmallest(Arrs.build2D("[[1,5,9],[10,11,13],[12,13,15]]"), 8));
    }

}
