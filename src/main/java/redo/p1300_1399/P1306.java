package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1306  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1306 {

    class Solution {
        public boolean canReach(int[] arr, int start) {
            return dfs(start, arr, new boolean[arr.length]);
        }

        public boolean dfs(int now, int[] arr, boolean[] visited) {
            if (now < 0 || now >= arr.length) {
                return false;
            }
            if (visited[now]) {
                return false;
            }
            if (arr[now] == 0) {
                return true;
            }
            visited[now] = true;
            return dfs(now - arr[now], arr, visited) || dfs(now + arr[now], arr, visited);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canReach(new int[] {4, 2, 3, 0, 3, 1, 2}, 5));
        Assert.assertEquals(true, s.canReach(new int[] {4, 2, 3, 0, 3, 1, 2}, 0));
        Assert.assertEquals(false, s.canReach(new int[] {3, 0, 2, 1, 2}, 2));
    }

}
