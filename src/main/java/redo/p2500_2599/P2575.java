package redo.p2500_2599;

public class P2575 {

    class Solution {
        public int[] divisibilityArray(String word, int m) {
            long now = 0;
            int[] ans = new int[word.length()];
            for (int i = 0; i < word.length(); ++i) {
                now = (now * 10 + word.charAt(i) - '0') % m;
                ans[i] = now == 0 ? 1 : 0;
            }
            return ans;
        }
    }

}
