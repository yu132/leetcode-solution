package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1334  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1334 {

    static//

    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
            int[][] distances = toAdjacencyArray(n, edges, distanceThreshold + 1);
            floyd(distances, distanceThreshold + 1);
            int min = Integer.MAX_VALUE, minCity = -1;
            for (int i = 0; i < n; ++i) {
                int count = 0;
                for (int j = 0; j < n; ++j) {
                    if (i != j) {
                        if (distances[i][j] <= distanceThreshold) {
                            ++count;
                        }
                    }
                }
                if (count <= min) {
                    min = count;
                    minCity = i;
                }
            }
            return minCity;
        }

        static void floyd(int[][] distances, int maxLen) {
            int n = distances.length;
            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        int loose = distances[i][k] + distances[k][j];
                        if (loose < maxLen && loose < distances[i][j]) {
                            distances[i][j] = loose;
                        }
                    }
                }
            }
        }

        // 无向图
        public int[][] toAdjacencyArray(int n, int[][] edges, int maxLen) {
            int[][] distances = new int[n][n];
            for (int[] arr : distances) {
                Arrays.fill(arr, maxLen);
            }
            for (int[] edge : edges) {
                distances[edge[0]][edge[1]] = edge[2];
                distances[edge[1]][edge[0]] = edge[2];
            }
            return distances;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findTheCity(4, Arrs.build2D("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]"), 4));
        Assert.assertEquals(0, s.findTheCity(5, Arrs.build2D("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]"), 2));
    }

}
