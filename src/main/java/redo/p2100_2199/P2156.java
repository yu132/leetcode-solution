package redo.p2100_2199;

public class P2156 {

    class Solution {
        public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
            int n = s.length();
            long sum = 0, basePow = 1;
            for (int i = n - 1; i >= n - k; --i) {
                sum = (sum * power + toVal(s.charAt(i))) % modulo;
                if (i != n - k) {
                    basePow = (basePow * power) % modulo;
                }
            }
            int ans = -1;
            if (sum == hashValue) {
                ans = n - k;
            }
            for (int i = n - k - 1; i >= 0; --i) {
                sum = ((sum - (toVal(s.charAt(i + k)) * basePow) % modulo + modulo) * power + toVal(s.charAt(i))) % modulo;
                if (sum == hashValue) {
                    ans = i;
                }
            }
            return s.substring(ans, ans + k);
        }

        public int toVal(char ch) {
            return ch - 'a' + 1;
        }
    }

    public static void main(String[] args) {
        new P2156().new Solution().subStrHash("leetcode", 7, 20, 2, 0);
    }

}
