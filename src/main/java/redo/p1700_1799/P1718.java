package redo.p1700_1799;

public class P1718 {

    class Solution {

        public int[] constructDistancedSequence(int n) {
            int[] ans = new int[n * 2 - 1];
            boolean[] used = new boolean[n];
            backtrack(ans, 0, used);
            return ans;
        }

        boolean backtrack(int[] ans, int index, boolean[] used) {
            if (index == ans.length) {
                return true;
            }
            if (ans[index] != 0) {
                return backtrack(ans, index + 1, used);
            }
            for (int i = used.length; i > 1; --i) {
                if (!used[i - 1] && i + index < ans.length && ans[i + index] == 0) {
                    ans[index] = ans[i + index] = i;
                    used[i - 1] = true;
                    if (backtrack(ans, index + 1, used)) {
                        return true;
                    }
                    used[i - 1] = false;
                    ans[index] = ans[i + index] = 0;
                }
            }
            if (!used[0]) {
                ans[index] = 1;
                used[0] = true;
                if (backtrack(ans, index + 1, used)) {
                    return true;
                }
                ans[index] = 0;
                used[0] = false;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        new P1718().new Solution().constructDistancedSequence(6);
    }

}
