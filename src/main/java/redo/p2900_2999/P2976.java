package redo.p2900_2999;

import java.util.Arrays;

public class P2976 {

    class Solution {
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            int[][] distance = new int[26][26];
            for (int[] arr : distance) {
                Arrays.fill(arr, Integer.MAX_VALUE / 10);
            }
            for (int i = 0; i < 26; ++i) {
                distance[i][i] = 0;
            }
            for (int i = 0; i < original.length; ++i) {
                distance[original[i] - 'a'][changed[i] - 'a'] = Math.min(distance[original[i] - 'a'][changed[i] - 'a'], cost[i]);
            }
            floyd(distance, Integer.MAX_VALUE / 10);
            long ans = 0;
            for (int i = 0; i < source.length(); ++i) {
                int dis = distance[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (dis >= Integer.MAX_VALUE / 10) {
                    return -1;
                }
                ans += dis;
            }
            return ans;
        }

        void floyd(int[][] distances, int maxLen) {
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
    }


}
