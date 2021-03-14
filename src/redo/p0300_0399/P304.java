package redo.p0300_0399;

/**  
 * @ClassName: P304  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P304 {

    static//

    class NumMatrix {

        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            prefix = prefix2D(matrix);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum2DRange(row1, col1, row2, col2, prefix);
        }

        public static int[][] prefix2D(int[][] nums) {
            int[][] prefix = new int[nums.length + 1][nums[0].length + 1];
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums[0].length; ++j) {
                    prefix[i + 1][j + 1] = nums[i][j] + prefix[i][j + 1]
                        + prefix[i + 1][j] - prefix[i][j];
                }
            }
            return prefix;
        }

        // x2和y2是包括的右下角边界
        public static int sum2DRange(int x1, int y1, int x2, int y2,
            int[][] prefix) {
            return prefix[x2 + 1][y2 + 1] - prefix[x2 + 1][y1]
                - prefix[x1][y2 + 1] + prefix[x1][y1];
        }
    }

}
