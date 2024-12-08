package redo.p2900_2999;

public class P2924 {

    class Solution {
        public int findChampion(int n, int[][] edges) {
            boolean[] in = new boolean[n];
            for (int[] edge : edges) {
                in[edge[1]] = true;
            }
            int only = -1;
            for (int i = 0; i < n; ++i) {
                if (!in[i] && only != -1) {
                    return -1;
                } else if (!in[i]) {
                    only = i;
                }
            }
            return only;
        }
    }

}
