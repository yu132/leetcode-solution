package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P13  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P13 {

    class Solution {
        public int movingCount(int m, int n, int k) {
            return dfs(0, 0, m, n, k, new boolean[m][n]);
        }

        public int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return 0;
            }
            if (visited[x][y]) {
                return 0;
            }
            visited[x][y] = true;
            if (digitSum(x) + digitSum(y) > k) {
                return 0;
            }
            return 1 + dfs(x + 1, y, m, n, k, visited)
                + dfs(x - 1, y, m, n, k, visited)
                + dfs(x, y + 1, m, n, k, visited)
                + dfs(x, y - 1, m, n, k, visited);
        }

        public int digitSum(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.movingCount(2, 3, 1));
        Assert.assertEquals(1, s.movingCount(3, 1, 0));
    }

}
