package redo.p0800_0899;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P851  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P851 {

    class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            List<Integer>[] orderlyAdjacency = toOrderlyAdjacency(n, richer);

            boolean[] visited = new boolean[n];
            int[] ans = new int[n];

            for (int i = 0; i < n; ++i) {
                dfs(i, orderlyAdjacency, quiet, visited, ans);
            }

            return ans;
        }

        int dfs(int x, List<Integer>[] orderlyAdjacency, int[] quiet, boolean[] visited, int[] ans) {
            if (visited[x]) {
                return ans[x];
            }
            visited[x] = true;

            int qLevel = quiet[x], qPeople = x;
            for (int richer : orderlyAdjacency[x]) {
                int mostQuiet = dfs(richer, orderlyAdjacency, quiet, visited, ans);
                if (quiet[mostQuiet] < qLevel) {
                    qLevel = quiet[mostQuiet];
                    qPeople = mostQuiet;
                }
            }
            ans[x] = qPeople;
            return qPeople;
        }

        public List<Integer>[] toOrderlyAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[1]].add(edge[0]);
            }

            return adjacency;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {5, 5, 2, 5, 4, 5, 6, 7}, s.loudAndRich(
            Arrs.build2D("[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]"), new int[] {3, 2, 5, 4, 6, 1, 7, 0}));
    }
}
