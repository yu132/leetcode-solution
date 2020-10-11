package _0500_0599;

/**  
 * @ClassName: _562  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _562 {

    class Solution {
        public int longestLine(int[][] M) {

            if (M.length == 0) {
                return 0;
            }

            int max = 0;

            for (int i = 0; i < M.length; ++i) {
                int sum = 0;
                for (int j = 0; j < M[0].length; ++j) {
                    if (M[i][j] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[i][j];
                    }
                }
            }

            for (int j = 0; j < M[0].length; ++j) {
                int sum = 0;
                for (int i = 0; i < M.length; ++i) {
                    if (M[i][j] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[i][j];
                    }
                }
            }

            for (int i = 0; i < M.length; ++i) {
                int x = i, y = 0, sum = 0;
                while (x < M.length && y < M[0].length) {
                    if (M[x][y] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[x][y];
                    }
                    ++x;
                    ++y;
                }
            }

            for (int j = 0; j < M[0].length; ++j) {
                int x = 0, y = j, sum = 0;
                while (x < M.length && y < M[0].length) {
                    if (M[x][y] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[x][y];
                    }
                    ++x;
                    ++y;
                }
            }

            for (int i = 0; i < M.length; ++i) {
                int x = i, y = M[0].length - 1, sum = 0;
                while (x < M.length && y >= 0) {
                    if (M[x][y] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[x][y];
                    }
                    ++x;
                    --y;
                }
            }

            for (int j = 0; j < M[0].length; ++j) {
                int x = 0, y = j, sum = 0;
                while (x < M.length && y >= 0) {
                    if (M[x][y] == 0) {
                        max = Math.max(max, sum);
                        sum = 0;
                    } else {
                        sum += M[x][y];
                    }
                    ++x;
                    --y;
                }
            }

            return max;
        }
    }
    /*
    [0,1,0,1,1],
    [1,1,0,0,1],
    [0,0,0,1,0],
    [1,0,1,1,1],
    [1,0,0,0,1]]
    
    */
}

