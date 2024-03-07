package redo.p2800_2899;

public class P2844 {

    class Solution {
        public int minimumOperations(String num) {
            String[] match = new String[]{"00", "25", "50", "75"};
            int max = -2;
            for (int i = 0; i < match.length; ++i) {
                int idx = num.length() - 1;
                while (idx >= 0 && num.charAt(idx) != match[i].charAt(1)) {
                    --idx;
                }
                if (idx == -1) {
                    continue;
                }
                --idx;
                while (idx >= 0 && num.charAt(idx) != match[i].charAt(0)) {
                    --idx;
                }
                if (idx == -2) {
                    continue;
                }
                --idx;
                max = Math.max(max, idx);
            }
            if (max != -2) {
                return num.length() - (max + 3);
            }
            for (int i = 0; i < num.length(); ++i) {
                if (num.charAt(i) == '0') {
                    return num.length() - 1;
                }
            }
            return num.length();
        }
    }

    public static void main(String[] args) {
        new P2844().new Solution().minimumOperations("25");
    }
}
