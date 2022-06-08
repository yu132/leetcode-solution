package lcof;

/**  
 * @ClassName: M13  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月14日  
 *  
 */
public class M13 {

    class Solution {
        public int movingCount(int m, int n, int k) {
            return dfs(m, n, 0, 0, new boolean[m][n], k);
        }

        public int dfs(int m, int n, int x, int y, boolean[][] visited, int k) {
            if (x >= m || x < 0) {
                return 0;
            } else if (y >= n || y < 0) {
                return 0;
            } else if (visited[x][y]) {
                return 0;
            } else if (sumDigit(x) + sumDigit(y) > k) {
                return 0;
            }

            visited[x][y] = true;

            int count = 1;

            count += dfs(m, n, x + 1, y, visited, k);
            count += dfs(m, n, x - 1, y, visited, k);
            count += dfs(m, n, x, y + 1, visited, k);
            count += dfs(m, n, x, y - 1, visited, k);

            return count;
        }

        public int sumDigit(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n   /= 10;
            }
            return sum;
        }

    }

}
