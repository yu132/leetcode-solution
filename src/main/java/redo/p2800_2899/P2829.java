package redo.p2800_2899;

public class P2829 {

    class Solution {
        public int minimumSum(int n, int k) {
            boolean[] used = new boolean[200];
            int ans = 0;
            for (int i = 1, c = 0; c < n; ++i) {
                if (k > i && used[k - i]) {
                    continue;
                }
                used[i] = true;
                ++c;
                ans += i;
            }
            return ans;
        }
    }

}
