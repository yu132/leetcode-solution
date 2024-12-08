package redo.p2900_2999;

public class P2928 {

    static //

    class Solution {
        public int distributeCandies(int n, int limit) {
            int ans = 0;
            for (int i = 0; i <= Math.min(n, limit); ++i) {
                for (int j = 0; j <= Math.min(n - i, limit); ++j) {
                    if (n - i - j <= limit) {
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().distributeCandies(5, 2);
    }

}
