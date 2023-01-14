package old._1000_1099;

/**  
 * @ClassName: _1020  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1020 {

    class Solution {
        public int numEnclaves(int[][] A) {
            for (int i = 0; i < A.length; ++i) {
                dfs(i, 0, A, 1, 2);
                dfs(i, A[0].length - 1, A, 1, 2);
            }

            for (int i = 0; i < A[0].length; ++i) {
                dfs(0, i, A, 1, 2);
                dfs(A.length - 1, i, A, 1, 2);
            }

            int count = 0;
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < A[0].length; ++j) {
                    if (A[i][j] == 1) {
                        ++count;
                    }
                }
            }

            return count;
        }

        public void dfs(int x, int y, int[][] A, int tar, int color) {
            if (x < 0 || x >= A.length || y < 0 || y >= A[0].length) {
                return;
            }
            if (A[x][y] != tar) {
                return;
            }
            A[x][y] = color;
            dfs(x + 1, y, A, tar, color);
            dfs(x - 1, y, A, tar, color);
            dfs(x, y + 1, A, tar, color);
            dfs(x, y - 1, A, tar, color);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1020().new Solution()
            .numEnclaves(new int[][] {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));
    }


}
