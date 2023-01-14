package redo.zhousai;

public class P6099 {

    class Solution {
        public int longestSubsequence(String s, int k) {
            long base = 1;
            long now = 0;
            int len = 0;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '1') {
                    if (len > 32 || now + base > k) {
                        continue;
                    }
                    now += base;
                    ++len;
                    base *= 2;
                } else {
                    ++len;
                    base *= 2;
                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        new P6099().new Solution().longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101", 11713332);
    }


}
