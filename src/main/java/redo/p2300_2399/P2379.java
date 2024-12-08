package redo.p2300_2399;

public class P2379 {

    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int countWhite = 0;
            for (int i = 0; i < k; ++i) {
                if (blocks.charAt(i) == 'W') {
                    ++countWhite;
                }
            }
            int ans = countWhite;
            for (int i = k; i < blocks.length(); ++i) {
                if (blocks.charAt(i - k) == 'W') {
                    --countWhite;
                }
                if (blocks.charAt(i) == 'W') {
                    ++countWhite;
                }
                ans = Math.min(ans, countWhite);
            }
            return ans;
        }
    }

}
