package redo.Util.ag.array2D;

/**  
 * @ClassName: Sorted2DArrayUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class Sorted2DArrayUtil {

    // test by leetcode-378
    public int minK(int[][] matrix, int k) {
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
