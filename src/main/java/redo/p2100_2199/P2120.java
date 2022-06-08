package redo.p2100_2199;

public class P2120 {

    class Solution {
        public int[] executeInstructions(int n, int[] startPos, String s) {
            int[] ans = new int[s.length()];
            for (int i = 0; i < s.length(); ++i) {
                ans[i] = helper(n, startPos, s, i);
            }
            return ans;
        }

        public int helper(int n, int[] start, String s, int startIndex) {
            int x = start[0], y = start[1];
            for (int i = startIndex; i < s.length(); ++i) {
                switch (s.charAt(i)) {
                    case 'L':
                        --y;
                        break;
                    case 'R':
                        ++y;
                        break;
                    case 'U':
                        --x;
                        break;
                    case 'D':
                        ++x;
                        break;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    return i - startIndex;
                }
            }
            return s.length() - startIndex;
        }
    }

}
