package _1100_1199;

import java.util.Arrays;

/**  
 * @ClassName: _1135  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1135 {

    class Solution {

        public int find(int[] arr, int x) {
            return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
        }

        public int minimumCost(int N, int[][] connections) {

            int[] uf = new int[N + 1];
            Arrays.setAll(uf, (x) -> x);

            Arrays.sort(connections, (a, b) -> {
                return Integer.compare(a[2], b[2]);
            });

            int count = 0;
            for (int[] edge : connections) {
                if (find(uf, edge[0]) == find(uf, edge[1])) {
                    continue;
                } else {
                    count                 += edge[2];
                    uf[find(uf, edge[0])]  = edge[1];
                    --N;
                }
            }

            if (N == 1) {
                return count;
            } else {
                return -1;
            }
        }
    }

}
