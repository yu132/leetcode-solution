package redo.p2200_2299;

public class P2243 {

    class Solution {
        public String digitSum(String s, int k) {
            while (s.length() > k) {
                StringBuilder buf = new StringBuilder(s.length());
                for (int i = 0; i < s.length(); i += k) {
                    int val = 0;
                    for (int j = i; j < s.length() && j < i + k; ++j) {
                        val += s.charAt(j) - '0';
                    }
                    buf.append(val);
                }
                s = buf.toString();
            }
            return s;
        }
    }

    public static void main(String[] args) {
        new P2243().new Solution().digitSum("11111222223", 3);
    }
}
